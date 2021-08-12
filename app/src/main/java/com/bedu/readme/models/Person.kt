package models

open class Person(private val id:Int, private var name: String, var userName: String, private var password:String) {
    fun getId():Int = id
    fun getName():String = name
    @JvmName("getUserName1")
    fun getUserName():String = userName
    fun getPassword():String = password
}