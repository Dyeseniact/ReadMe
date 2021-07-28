package models

open class Person(private val id:Int, private var name: String, private var userName: String, private var password:String) {
    fun getId():Int = id
    fun getName():String = name
    fun getUserName():String = userName
    fun getPassword():String = password
}