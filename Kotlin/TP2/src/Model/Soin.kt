package Model

class Soin(var id: Int, var num: Int, var numMaxRange: Int = 0, var categorie: String) {

    fun IsInRange(numValue: Int):Boolean {
        if(numMaxRange == 0)
            return numValue == num

        return numValue in num..numMaxRange
    }
}