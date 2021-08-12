package com.bedu.readme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

lateinit var numeroTarjeta:EditText
lateinit var nombreTarjeta:EditText
lateinit var fechaTarjeta:EditText
lateinit var cvv:EditText
lateinit var imagenTarjeta:ImageView
class Act_card : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_card)

        imagenTarjeta = findViewById(R.id.imageTarjeta)
        numeroTarjeta = findViewById(R.id.editText_CardNumber)
        nombreTarjeta = findViewById(R.id.editText_NameCard)
        fechaTarjeta= findViewById(R.id.editText_dateCard)
        var botonGuardar =findViewById<Button>(R.id.btnUpdate)
        var botonCancelar =findViewById<Button>(R.id.btn_cancelar)

        cvv = findViewById(R.id.editText_cvv)
        numeroTarjeta.setOnFocusChangeListener { it, b ->   imagenTarjeta.setImageResource(R.drawable.tarjetanumero)}
        nombreTarjeta.setOnFocusChangeListener { it, b ->   imagenTarjeta.setImageResource(R.drawable.tarjetanombre)}
        fechaTarjeta.setOnFocusChangeListener { it, b ->   imagenTarjeta.setImageResource(R.drawable.tarjetafecha)}
        cvv.setOnFocusChangeListener { it, b ->   imagenTarjeta.setImageResource(R.drawable.tarjetacvv)}

        botonGuardar.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }

        botonCancelar.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }



    }
}