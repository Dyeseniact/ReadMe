package com.bedu.readme

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.flaviofaria.kenburnsview.KenBurnsView


fun dialog(title:String,message:String, context: Context){
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK"){dialogInterface, which -> }
        .create()
        .show()
}

fun Context.diaglog(inflater: LayoutInflater, titleLiterature: String, authorLiteratura:String ){
    //Para usarlo debes desplegarlo de la siguiente manera:
    //diaglog(layoutInflater,"Este es u título","Esta es su descripción")
    //la función necesita el layoutInfleter del principio para funcionar

    val ventana = inflater.inflate(R.layout.card_literature_selected,null)
    //Componentes de la ventana
    val textViewTitle = ventana.findViewById<TextView>(R.id.cardLiteratureSelectedTextTitle)
    val textViewAuthor = ventana.findViewById<TextView>(R.id.cardLiteratureSelectedTextAuthor)
    val buttonBuy = ventana.findViewById<Button>(R.id.cardLiteratureSelectedButtonBuy)
    val buttonRent = ventana.findViewById<Button>(R.id.cardLiteratureSelectedButtonRent)
    val imageView = ventana.findViewById<ImageView>(R.id.cardLiteratureSelectedImage)
    val imageBackground = ventana.findViewById<KenBurnsView>(R.id.cardLiteratureSelectedImageBack)

    //Modificaci[on de los componentes
    textViewTitle.text = titleLiterature
    textViewAuthor.text = authorLiteratura

    //Creación del cuadro de diálogo
    val builder = AlertDialog.Builder(this)
    builder.setView(ventana)
    val alertDialog = builder.create()
    alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    //Acciones de los botones que afectan al cuadro de diálogo
    buttonBuy.setOnClickListener{ alertDialog.dismiss() }
    buttonRent.setOnClickListener { alertDialog.dismiss() }

    alertDialog.show()
}


fun showToast(context: Context, text:String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}