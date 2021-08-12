package com.bedu.readme

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import me.ibrahimsn.lib.SmoothBottomBar
import models.listBook


@SuppressLint("StaticFieldLeak")

private lateinit var txtConfirmacion: TextView
private lateinit var txtMontoCobrado: TextView
private lateinit var imDone: ImageView

private lateinit var btnAccept: Button



class Act_ConfirmarPago : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_confirmar_pago)



        txtConfirmacion = findViewById(R.id.txtConfirmacion)
        txtMontoCobrado = findViewById(R.id.txtMontoCobrado)
        txtMontoCobrado.text = "Se realizó un cobro de ${listBook[3]?.price} MXN"

        imDone = findViewById(R.id.imgDone)


        btnAccept = findViewById(R.id.btnAccept)


        btnAccept.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }





    }
}

