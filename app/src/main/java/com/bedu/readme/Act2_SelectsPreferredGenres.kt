package com.bedu.readme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class Act2_SelectsPreferredGenres : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2_selects_preferred_genres)
        var button = findViewById<Button>(R.id.btnSelect)

        button.setOnClickListener {

            val snack = Snackbar.make(it, "Géneros seleccionados", Snackbar.LENGTH_LONG).setDuration(500)
            snack.show()

            Handler().postDelayed({
                startActivity(Intent(this, Act1_login::class.java))
                finish()
            }, 300)

        }
    }

    override fun onBackPressed(){
        val intent = Intent(this,Act3_Home::class.java)
        startActivity(intent)
        finish()
    }


}