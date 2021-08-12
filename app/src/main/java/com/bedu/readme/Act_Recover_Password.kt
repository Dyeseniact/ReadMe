package com.bedu.readme

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class Act_Recover_Password  : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recover_password)

        var email = findViewById<EditText>(R.id.editText_email_recover)
        var btnRecover = findViewById<Button>(R.id.btn_recover_password)

        btnRecover.setOnClickListener {
            if(email.text.trim().isNotEmpty()){
                Toast.makeText(this,"Hemos enviado un correo con las intrucciones, para que puedas recuperar tu contraseña.", Toast.LENGTH_LONG).show()
                Handler().postDelayed({
                    startActivity(Intent(this, Activity_act1_login::class.java))
                    finish()
                }, 1500)
            }
            else {
                Toast.makeText(this,"Error, debes escribir un correo.", Toast.LENGTH_LONG).show()
            }
        }

    }


}