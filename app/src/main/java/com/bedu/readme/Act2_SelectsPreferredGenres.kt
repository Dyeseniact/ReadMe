package com.bedu.readme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Act2_SelectsPreferredGenres : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2_selects_preferred_genres)
        var button = findViewById<Button>(R.id.continuarGeneros)

        button.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java).apply{

            }

            startActivity(intent)
        }
    }



}