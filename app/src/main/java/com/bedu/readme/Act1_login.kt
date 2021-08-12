package com.bedu.readme

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import db.*
import models.User

lateinit var userLogin: User
var runProgram = true
var loginAnswer = ""
var selection = 100
lateinit var currentUser: String
lateinit var currentEmail: String
var currentCount: Int=0

var loginactive: Activity? = null

class Act1_login : AppCompatActivity() {
    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_act1_login)

        var email = findViewById<EditText>(R.id.editText_email)
        var password = findViewById<EditText>(R.id.editText_password)
        var btnLogin = findViewById<Button>(R.id.btn_login)
        var btnRegister = findViewById<Button>(R.id.btn_register)
        var btnRecoverPassword = findViewById<TextView>(R.id.textView_pass_recover)

        sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        if(sharedPreferences.getBoolean("userLog",false)){

            currentCount = sharedPreferences.getInt("userId",1)-1
            userLogin = User(
                sharedPreferences.getInt("userId",5000),
                sharedPreferences.getString("userName","")!!,
                sharedPreferences.getString("userUserName","")!!,
                sharedPreferences.getString("userPassword","")!!,
                sharedPreferences.getString("userEmail","")!!,
                sharedPreferences.getString("userTypeAccount","")!!,
                arrayListOf(
                    returnMyPreferences(sharedPreferences.getString("userPreferredBooks","")!!),
                    returnMyPreferences(sharedPreferences.getString("userPreferredMagazine","")!!),
                    returnMyPreferences(sharedPreferences.getString("userPreferredArticle","")!!))
            )
            continueHome()
        }

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

        btnRecoverPassword.setOnClickListener {
            val intent = Intent(this,Act_Recover_Password::class.java).apply{}
            startActivity(intent)
            finish()
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this,Act2_Signin::class.java).apply{}
            startActivity(intent)
            loginactive = this
        }
    }

    private fun continueHome(){
        val intent = Intent(this,Act3_Home::class.java).apply{}
        startActivity(intent)
        finish()
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
                    editor.putBoolean("userLog",true).apply()
                    editor.putInt("userId", userLogin.getId()).apply()
                    editor.putString("userName", userLogin.getName() ).apply()
                    editor.putString("userUserName", userLogin.getUserName() ).apply()
                    editor.putString("userPassword", userLogin.getPassword() ).apply()
                    editor.putString("userEmail", userLogin.getEmail() ).apply()
                    editor.putString("userTypeAccount", userLogin.getEmail() ).apply()
                    editor.putString("userPreferredBooks",
                        ", "+userLogin.preferredGenre[0].toString().replace("[","")
                            .replace("]","")+",").apply()
                    editor.putString("userPreferredMagazine",
                        ", "+userLogin.preferredGenre[1].toString().replace("[","")
                            .replace("]","")+",").apply()
                    editor.putString("userPreferredArticle",
                        ", "+userLogin.preferredGenre[2].toString().replace("[","")
                            .replace("]","")+",").apply()
                    currentCount=i
                    return "ok"
                }else{
                    return "badPassword"
                    }
                }

        }
        return "badUser"
    }

}