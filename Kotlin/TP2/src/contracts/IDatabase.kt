package contracts

import Model.Couverture

interface IDatabase {

    fun Startup()
    fun CouvertureOfferte(soinNum: Int, typeContrat: String): Couverture
    fun SoinExiste(soinNum: Int): Boolean

}