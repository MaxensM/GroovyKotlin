package Model

class Soins(var soins:List<Soin>) {

    fun Find(soinNum:Int):Soin{

        soins.forEach {
            if(it.IsInRange(soinNum))
                return it
        }

        return Soin(0, 0, 0, "")

    }

}
