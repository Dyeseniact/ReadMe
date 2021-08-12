package com.bedu.readme

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import db.*
import models.User


class Act2_Signin : AppCompatActivity() {

    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2_signin)

        sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val name = findViewById<TextView>(R.id.editText_name_register)
        val userName = findViewById<TextView>(R.id.editText_emailUpdate)
        val email = findViewById<TextView>(R.id.editText_email_register)
        val password = findViewById<TextView>(R.id.editText_password_register)
        val phone = findViewById<TextView>(R.id.editText_phone_register)
        val buttonRegistrar = findViewById<Button>(R.id.btn_register_user)

        buttonRegistrar.setOnClickListener {
            if( (name.text.trim().isNotEmpty()) && (userName.text.trim().isNotEmpty()) && (email.text.trim().isNotEmpty()) && (password.text.trim().isNotEmpty()) && (phone.text.trim().isNotEmpty())){
                val newUser = User(countUsers+1,name.text.toString(),userName.text.toString(),password.text.toString(),email.text.toString(),
                    "user", arrayListOf(mutableSetOf(), mutableSetOf(), mutableSetOf()) )

                listUsr[countUsers]= newUser
                userLogin = newUser

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


                countUsers++

                mensaje("¡Bienvenido a la comunidad!","Es lo que lees cuando no tienes que hacerlo, lo que determina lo que serás. -Oscar Wilde.")
            }else{
                Toast.makeText(this,"Error, debes de llenar todos los campos", Toast.LENGTH_LONG).show()
            }
        }

    }
    private fun mensaje(title:String,message:String){
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK"){dialogInterface, which ->
                val intent = Intent(this,Act2_SelectsPreferredGenres::class.java)
                startActivity(intent)
                loginactive?.finish()
                finish()
            }
            .create()
            .show()
    }

}