package Model

import Database.Repository
import org.junit.Assert.*
import org.junit.Test

class ReglesTest{
    @Test
    fun CalculerTest() {
        var contrats = Contrats(arrayOf<Contrat>( Contrat("A") ).toList())
        var soins = Soins(arrayOf<Soin>( Soin(1, 100, 0, "") ).toList())
        var couvertures = Couvertures(arrayOf<Couverture>( Couverture(1, "A", 10, 20) ).toList())
        Tp2Factory.repo = Repository(contrats, soins, couvertures)

        var reclamations = arrayOf<Reclamation>(Reclamation(100, "2018-01", "15$")).toList()
        var demandeur = Demandeur("001", "A", "2018-01", reclamations)

        var beneficiaire = Regles.Calculer(demandeur)

        assertEquals("001", beneficiaire.client)
        assertEquals("2018-01", beneficiaire.mois)
        assertEquals(1, beneficiaire.remboursements.count())
        assertEquals("1.50$", beneficiaire.remboursements[0].montant)
        assertEquals("2018-01", beneficiaire.remboursements[0].date)
        assertEquals(100, beneficiaire.remboursements[0].soin)

    }

    @Test
    fun CalculerOverMaxTest() {
        var contrats = Contrats(arrayOf<Contrat>( Contrat("A") ).toList())
        var soins = Soins(arrayOf<Soin>( Soin(1, 100, 0, "") ).toList())
        var couvertures = Couvertures(arrayOf<Couverture>( Couverture(1, "A", 10, 20) ).toList())
        Tp2Factory.repo = Repository(contrats, soins, couvertures)

        var reclamations = arrayOf<Reclamation>(Reclamation(100, "2018-01", "25$")).toList()
        var demandeur = Demandeur("001", "A", "2018-01", reclamations)

        var beneficiaire = Regles.Calculer(demandeur)

        assertEquals("001", beneficiaire.client)
        assertEquals("2018-01", beneficiaire.mois)
        assertEquals(1, beneficiaire.remboursements.count())
        assertEquals("2.00$", beneficiaire.remboursements[0].montant)
        assertEquals("2018-01", beneficiaire.remboursements[0].date)
        assertEquals(100, beneficiaire.remboursements[0].soin)

    }

}