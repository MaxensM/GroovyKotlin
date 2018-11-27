package InOut

import com.google.gson.GsonBuilder
import contracts.ISortie
import java.io.FileWriter

class JsonOutput: ISortie {

    override fun <T>Write(data:T, pathOut: String){
        var gson = GsonBuilder().setPrettyPrinting().create()
        var writer = FileWriter(pathOut)

        gson.toJson(data, writer)

        writer.flush()
        writer.close()
    }

}