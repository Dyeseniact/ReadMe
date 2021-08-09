package com.bedu.readme

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        var email = findViewById<EditText>(R.id.editText_email)
        var password = findViewById<EditText>(R.id.editText_password)
        var btnLogin = findViewById<Button>(R.id.btn_login)
        var btnRegister = findViewById<Button>(R.id.btn_register)

        btnLogin.setOnClickListener {

            if ((email.text.trim().isNotEmpty()) && (password.text.trim().isNotEmpty())){
                var loginAnswer = login(email.text.toString(),password.text.toString())
                if(loginAnswer == "ok"){
                    val intent = Intent(this,Act3_Home::class.java).apply{}
                    startActivity(intent)
                    finish()
                }else if (loginAnswer == "badUser"){
                    Toast.makeText(this,"Usuario no encontrado", Toast.LENGTH_LONG).show()
                    email.setText("")
                    password.setText("")
                }else if(loginAnswer == "badPassword"){
                    Toast.makeText(this,"Contraseña incorrecta, intenta de nuevo", Toast.LENGTH_LONG).show()
                    password.setText("")
                }
            }else{
                Toast.makeText(this,"Error, debes de llenar todos los campos", Toast.LENGTH_LONG).show()
            }
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this,Act2_signin::class.java).apply{}
            startActivity(intent)
            finish()
        }
    }

    private fun loginUser(email: String, password: String):String {
        var answer = ""

        for(i in 0..99) {
            if (listUsr[i]?.getTypeAccount() == "user" && listUsr[i]?.getEmail() == email && listUsr[i]?.getPassword() == password) {
                answer = "ok"
            } else if (listUsr[i]?.getTypeAccount() == "user" && listUsr[i]?.getEmail() == email && listUsr[i]?.getPassword() !== password) {
                answer = "badPassword"
            }else {
                answer = "badUser"
            }
        }

        return answer
    }

    fun login(email: String, password: String): String{

        for(i in 0..99){
            if(listUsr[i]?.getTypeAccount()== "user" && listUsr[i]?.getEmail() == email){
                if( listUsr[i]?.getPassword() == password){
                    userLogin = listUsr[i]!!
                    return "ok"
                }else{
                    return "badPassword"
                    }
                }

        }
        return "badUser"
    }

}