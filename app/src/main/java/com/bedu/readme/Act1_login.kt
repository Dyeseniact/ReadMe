package com.bedu.readme

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import db.*
import models.User

lateinit var userLogin: User
var runProgram = true
var loginAnswer = ""
var selection = 100
class Activity_act1_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDBAdmins()
        createDBBooks()
        createDBArticle()
        createDBMagazine()
        setContentView(R.layout.activity_act1_login)
        var email = findViewById<EditText>(R.id.editTextEmailLogin)
        var password = findViewById<EditText>(R.id.editTextPasswordLogin)
        var btnLogin = findViewById<Button>(R.id.btnIniciarSesion)
        var btnRegistrar = findViewById<Button>(R.id.buttonCrearCuentaLogin)

        btnLogin.setOnClickListener {
            var emailtext = ""
            if ((email.text.toString()!="") && (password.text.toString()!="")){
                //println("correo: ${email.text.toString()} password: ${password.text.toString()}")
                var loginAnswer = login(email.text.toString(),password.text.toString())
                if(loginAnswer.equals("user")||loginAnswer.equals("admin")){
                    val intent = Intent(this,Act3_Home::class.java).apply{
                    }
                    startActivity(intent)
                    finish()
                }else{
                    mensaje("¡Parece que algo ha faltado! :( ","El usuario o la contraseña no son correctos")
                }
            }else{
                println("Debes de llenar todos los campos")
                mensaje("¡Parece que algo ha faltado! :( ","Todos los campos son obligatorios")
            }
        }
        btnRegistrar.setOnClickListener {
            val intent = Intent(this,Act2_signin::class.java).apply{
            }
            startActivity(intent)
            finish()
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
    fun login(email: String, password: String): String{
        println("correo: ${email} password: ${password}")
        for(i in 0..99){
            if(listUsr[i]?.getTypeAccount() == "admin" && listUsr[i]?.getEmail() == email && listUsr[i]?.getPassword() == password){
                userLogin = listUsr[i]!!
                return "admin"
            }else{
                if(listUsr[i]?.getTypeAccount()== "user" && listUsr[i]?.getEmail() == email){
                    if( listUsr[i]?.getPassword() == password){
                        userLogin = listUsr[i]!!
                        return "user"
                    }else{
                        return "userWrongPassword"
                    }
                }
            }
        }
        return "isnRegister"
    }
}