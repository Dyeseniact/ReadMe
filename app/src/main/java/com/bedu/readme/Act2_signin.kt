package com.bedu.readme

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import db.*
import models.User


class Act2_signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2_signin)

        createDBAdmins()
        createDBBooks()
        createDBArticle()
        createDBMagazine()
        var name = findViewById<TextView>(R.id.editTextName)
        var userName = findViewById<TextView>(R.id.editTextUserName)
        var email = findViewById<TextView>(R.id.editTextTextEmailAddress)
        var password = findViewById<TextView>(R.id.editTextTextPassword)
        var phone = findViewById<TextView>(R.id.editTextPhone)
        var buttonRegistrar = findViewById<Button>(R.id.btnRegistrarse)

        buttonRegistrar.setOnClickListener {
            if( (name.text.toString()!="")  && (userName.text.toString()!="") &&   (email.text.toString()!="")   &&   (password.text.toString()!="")    &&
                (phone.text.toString()!="")){
                listUsr[countUsers]= User(countUsers+1,name.text.toString(),userName.text.toString(),password.text.toString(),email.text.toString())
                println("El nuevo usuario es: nombre: ${listUsr[countUsers]?.getName()} usuario: ${listUsr[countUsers]?.getUserName()} " +
                        "contraseña: ${listUsr[countUsers]?.getPassword() }  email: ${listUsr[countUsers]?.getEmail()}   ")
                countUsers++
                Toast.makeText(applicationContext, "Selecccionaste el coche", Toast.LENGTH_SHORT
                ).show()
                mensaje("¡Bienvenido a la comunidad!","Es lo que lees cuando no tienes que hacerlo, lo que determina lo que serás. -Oscar Wilde.")

            }else{
                println("Debes de llenar todos los campos")
                mensaje("¡Parece que algo ha faltado! :( ","Todos los campos son obligatorios")
            }
        }




    }
    private fun mensaje(title:String,message:String){
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK"){dialogInterface, which -> }
            .create()
            .show()
    }

}