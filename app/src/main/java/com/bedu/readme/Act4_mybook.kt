package com.bedu.readme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Act4_mybook : AppCompatActivity() {

    private lateinit var homeButton: ImageView
    private lateinit var settingButton: ImageView
    private lateinit var bookButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act4_mybook)

        homeButton = findViewById(R.id.IVHome)
        settingButton = findViewById(R.id.IVSettings)
        bookButton = findViewById(R.id.IVBooks)

        homeButton.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }

        settingButton.setOnClickListener {
            val intent = Intent(this,Act5_Setting::class.java)
            startActivity(intent)
            finish()
        }
    }
}