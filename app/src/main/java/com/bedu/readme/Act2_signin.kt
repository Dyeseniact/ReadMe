package com.bedu.readme

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import db.*
import models.User


class Act2_signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2_signin)

        val name = findViewById<TextView>(R.id.editText_name_register)
        val userName = findViewById<TextView>(R.id.editText_emailUpdate)
        val email = findViewById<TextView>(R.id.editText_email_register)
        val password = findViewById<TextView>(R.id.editText_password_register)
        val phone = findViewById<TextView>(R.id.editText_phone_register)
        val buttonRegistrar = findViewById<Button>(R.id.btn_register_user)

        buttonRegistrar.setOnClickListener {
            if( (name.text.trim().isNotEmpty()) && (userName.text.trim().isNotEmpty()) && (email.text.trim().isNotEmpty()) && (password.text.trim().isNotEmpty()) && (phone.text.trim().isNotEmpty())){
                listUsr[countUsers]= User(countUsers+1,name.text.toString(),userName.text.toString(),password.text.toString(),email.text.toString())
                countUsers++
                mensaje("¡Bienvenido a la comunidad!","Es lo que lees cuando no tienes que hacerlo, lo que determina lo que serás. -Oscar Wilde.")
                val intent = Intent(this,Act3_Home::class.java).apply{}
                startActivity(intent)
                finish()
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
                finish()
            }
            .create()
            .show()
    }

}