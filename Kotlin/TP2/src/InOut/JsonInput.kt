package InOut

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import contracts.IEntre
import java.io.FileReader
import kotlin.reflect.KClass
import kotlin.reflect.full.createInstance

class JsonInput: IEntre {

    override fun <T:Any> Read(filename:String, kclass: KClass<T>): T
    {
        var gson = Gson()
        try {
            var reader = JsonReader(FileReader(filename))
            return gson.fromJson<T>(reader, kclass.java)
        }
        catch (ex: Exception) {
            return kclass.createInstance()
        }
    }

}