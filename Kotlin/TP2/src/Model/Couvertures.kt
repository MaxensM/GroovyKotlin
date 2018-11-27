package Model

class Couvertures(var couvertures:List<Couverture>) {

    fun Find(soinId: Int, typeContrat: String): Couverture{

        couvertures.forEach {
            if(it.soinId == soinId && it.typeContrat == typeContrat)
                return it
        }

        return Couverture(0, "",0)
    }
}