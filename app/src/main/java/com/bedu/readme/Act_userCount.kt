package com.bedu.readme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import db.listUsr

class Act_userCount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_user_count)

        var img = findViewById<ImageView>(R.id.imageEditProfile)
        var user = findViewById<TextView>(R.id.editText_userName)
        var email = findViewById<TextView>(R.id.editText_emailUpdate)
        var btnUpdate = findViewById<Button>(R.id.btnUpdate)
        var btnCancelar = findViewById<Button>(R.id.btn_cancelar)

        when(currentCount){
            0->img.setImageResource(R.drawable.erick)
            1->img.setImageResource(R.drawable.yess)
            2->img.setImageResource(R.drawable.janner)
            3->img.setImageResource(R.drawable.genaro)
            else -> img.setImageResource(R.drawable.img)
        }

        user.setText(listUsr[currentCount]?.userName)
        email.setText(listUsr[currentCount]?.getEmail())

        btnUpdate.setOnClickListener {
            println("el user es ${listUsr[currentCount]?.userName} la cuenta va en $currentCount")
            listUsr[currentCount]?.userName=user.text.toString()
            listUsr[currentCount]?.setEmail(email.text.toString())
            println("el nuevo user es ${listUsr[currentCount]?.userName} la cuenta va en $currentCount")
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }

        btnCancelar.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }


    }
}