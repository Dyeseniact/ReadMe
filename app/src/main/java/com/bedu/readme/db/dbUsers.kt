package db
import models.User

var listUsr = Array<User?>(100){null}
var countUsers = 0

fun createDBAdmins(){

    //Crea una lista con 4 administradores que están predeterminados
    var cambio:Boolean=false
    listUsr[countUsers]= User(countUsers+1,"Erick","ErickBedu",
        "1234erick","erick@gmail.com","admin")
    countUsers++
    listUsr[countUsers]= User(countUsers+1,"Yess","YessBedu",
        "1234yess","yess@gmail.com","admin")
    countUsers++
    listUsr[countUsers]= User(countUsers+1,"Janner","JannerBedu",
        "1234janner","janner@gmail.com","user", )//mutableSetOf("Romance"))
    countUsers++
    listUsr[countUsers]= User(countUsers+1,"Genaro","GenaroBedu",
        "1234genaro","genaro@gmail.com","user",
        arrayListOf(mutableSetOf("Ciencia Ficción", "Terror"),
            mutableSetOf("Multidisciplina","Artes y Humanidades"), mutableSetOf("Biologic")))
    countUsers++
}