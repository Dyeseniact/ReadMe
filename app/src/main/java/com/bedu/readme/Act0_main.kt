package com.bedu.readme


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import db.createDBAdmins
import db.createDBArticle
import db.createDBBooks
import db.createDBMagazine

@Suppress("DEPRECATION")
class Act0_main  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        createDBAdmins()
        createDBBooks()
        createDBArticle()
        createDBMagazine()


        Handler().postDelayed({
            startActivity(Intent(this, Act1_login::class.java))
            finish()
        }, 3000)
    }
}