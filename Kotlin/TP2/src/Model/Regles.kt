package Model

class Regles {

    companion object {

        fun Calculer(demandeur:Demandeur): Beneficiaire{

            var database = Tp2Factory.GetDb()

            var mutaList = mutableListOf<Remboursement>()

            demandeur.reclamations.forEach{
                var couverture = database.CouvertureOfferte(it.soin, demandeur.contrat)
                var montant = couverture.MontantCouvert(it.montant)
                var remboursement = Remboursement(it.soin, it.date, montant)
                mutaList.add(remboursement)
            }

            return Beneficiaire(demandeur.client, demandeur.mois, mutaList)
        }

        fun Valider(demandeur:Demandeur): String {
            var regex = """\d{6}""".toRegex()
            if (!regex.matches(demandeur.client))
                return "No de client invalide"

            regex = """[ABCD]""".toRegex()
            if (!regex.matches(demandeur.contrat))
                return "Type de contrat invalide"

            var database = Tp2Factory.GetDb()

            regex = """^\d{4}\-(0[1-9]|1[012])$""".toRegex()
            if(!regex.matches(demandeur.mois))
                return "Date de demande invalide"

            demandeur.reclamations.forEach{
                if (!database.SoinExiste(it.soin))
                    return "Numero de soin inexistant"

                if(!it.montant.endsWith("$"))
                    return "Montant sans $"

                regex = """^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$""".toRegex()
                if(!regex.matches(it.date))
                    return "Date de réclamation invalide"
                if(demandeur.mois != it.date.substring(0, 7))
                    return "Date de réclamation hors du mois de la demande"
            }

            return "";
        }
    }

}