package models

var listBook = Array<Book?>(40){null}
var countBook:Int=0
var listMagazine = Array<Magazine?>(30){null}
var countMagazine:Int=0
var listArticle = Array<Article?>(18){null}
var countArticle:Int=0
class User(id:Int, nombre:String, userName:String, password:String, private  var email: String, private var typeAccount:String="user",
           var preferredGenre: ArrayList<MutableSet<String>> = arrayListOf()) : Person(id, nombre, userName, password) {

    fun getEmail():String = email
    fun getTypeAccount():String = typeAccount

}