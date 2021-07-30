package com.bedu.readme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Act5_Setting : AppCompatActivity() {

    private lateinit var homeButton: ImageView
    private lateinit var settingButton: ImageView
    private lateinit var bookButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act5_setting)

        homeButton = findViewById(R.id.IVHome)
        settingButton = findViewById(R.id.IVSettings)
        bookButton = findViewById(R.id.IVBooks)

        homeButton.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }

        bookButton.setOnClickListener {
            val intent = Intent(this,Act4_mybook::class.java)
            startActivity(intent)
            finish()
        }
    }
}