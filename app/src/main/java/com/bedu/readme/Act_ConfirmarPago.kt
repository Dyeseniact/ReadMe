package com.bedu.readme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import me.ibrahimsn.lib.SmoothBottomBar


private lateinit var smoothBottomBar: SmoothBottomBar
private lateinit var txtConfirmacion: TextView


class Act_ConfirmarPago : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_confirmar_pago)



        txtConfirmacion = findViewById(R.id.txtConfirmacion)

        smoothBottomBar = findViewById(R.id.act3HomeFooter)





        smoothBottomBar.setOnItemSelectedListener {
            if(it == 0){
                //Agregar los cambios hacia las pantallas

//                val intent = Intent(this,Act3_Home::class.java)
//                startActivity(intent)
//                finish()
                Toast.makeText(this,"Aquí ejecuto Mis Libros", Toast.LENGTH_SHORT).show()
            }
            if (it == 1){
                val intent = Intent(this,Act3_Home::class.java)
                startActivity(intent)
                finish()
                //Toast.makeText(this,"Aquí ejecuto Tienda", Toast.LENGTH_SHORT).show()
            }
            if (it == 2){
                Toast.makeText(this,"Aquí ejecuto el menu de ajustes", Toast.LENGTH_SHORT).show()
            }
        }






    }
}