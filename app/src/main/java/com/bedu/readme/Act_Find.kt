package com.bedu.readme

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import com.google.android.material.textfield.TextInputLayout

@SuppressLint("StaticFieldLeak")
private lateinit var txtFind: TextInputLayout
@SuppressLint("StaticFieldLeak")
private lateinit var imFind: ImageView
@SuppressLint("StaticFieldLeak")
private lateinit var btnBack: ImageButton



class Act_Find : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_find)


       txtFind = findViewById(R.id.txtFind)
        imFind = findViewById(R.id.imFind)
        btnBack = findViewById(R.id.btnBack)


        btnBack.setOnClickListener{
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }

    }
}