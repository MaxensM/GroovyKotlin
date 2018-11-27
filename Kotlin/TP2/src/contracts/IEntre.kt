package contracts

import kotlin.reflect.KClass

interface IEntre {

    fun <T:Any> Read(filename:String, kclass: KClass<T>): T

}
