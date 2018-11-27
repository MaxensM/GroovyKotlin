package Model

class Demandeur(var client:String = "", var contrat:String = "", var mois: String = "",
                var reclamations:List<Reclamation> = emptyList()) {
}