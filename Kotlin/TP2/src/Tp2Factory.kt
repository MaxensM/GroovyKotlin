import Database.Repository
import InOut.JsonInput
import InOut.JsonOutput
import Model.*
import contracts.IDatabase
import contracts.IEntre
import contracts.ISortie

class Tp2Factory {

    companion object {
        fun GetEntree(): IEntre {
            return JsonInput()
        }

        fun GetSortie(): ISortie {
            return JsonOutput()
        }

        var repo : IDatabase? = null
        fun GetDb(): IDatabase {
            if(repo == null) {
                repo = Repository(Contrats(emptyList()), Soins(emptyList()), Couvertures(emptyList()))
                repo?.Startup()
            }
            return repo!!
        }
    }

}