package Tools

import java.math.BigDecimal

class Montant(val montant: String, var valeur: BigDecimal = BigDecimal.ZERO) {

    init {
        if(montant.endsWith("$"))
            valeur = BigDecimal.valueOf(montant.replace("$","").toDouble())
        else
            valeur = BigDecimal.valueOf(montant.toDouble())
    }

    override fun toString(): String {
        return String.format("%.2f", valeur) + "$"
    }

}