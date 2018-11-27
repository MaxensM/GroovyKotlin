package Model

import Tools.Montant
import java.math.BigDecimal

class Couverture(var soinId: Int, var typeContrat: String, var pourcentage: Int, var maximum:Int = 0) {

    fun MontantCouvert(montantReclame:String):String{
        var montant = Montant(montantReclame)
        var montantMax = Montant(maximum.toString())

        if(maximum > 0 && montant.valeur > montantMax.valeur)
            montant.valeur = montantMax.valeur

        var tmp = montant.valeur * BigDecimal.valueOf(pourcentage.toDouble())
        tmp = tmp.div(BigDecimal.valueOf(100.0))
        montant.valeur = tmp

        return montant.toString()
    }

}