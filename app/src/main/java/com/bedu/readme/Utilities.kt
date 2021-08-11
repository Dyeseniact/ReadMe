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
import com.bedu.readme.models.LiteratureRV
import com.flaviofaria.kenburnsview.KenBurnsView


fun Context.dialog(title:String,message:String, context: Context){
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setPositiveButton("OK"){dialogInterface, which -> }
        .create()
        .show()
}

fun diaglog(context: Context, inflater: LayoutInflater, literature: LiteratureRV){
    //Para usarlo debes desplegarlo de la siguiente manera:
    //diaglog(layoutInflater,"Este es u título","Esta es su descripción")
    //la función necesita el layoutInfleter del principio para funcionar

    val ventana = inflater.inflate(R.layout.card_literature_selected,null)
    //Componentes de la ventana
    val textViewTitle = ventana.findViewById<TextView>(R.id.cardLiteratureSelectedTextTitle)
    val textViewAuthor = ventana.findViewById<TextView>(R.id.cardLiteratureSelectedTextAuthor)
    val textViewPrice = ventana.findViewById<TextView>(R.id.cardLiteratureTextPrice)
    val buttonBuy = ventana.findViewById<Button>(R.id.cardLiteratureSelectedButtonBuy)
    val buttonPreview = ventana.findViewById<Button>(R.id.cardLiteratureSelectedButtonPreview)
    val imageView = ventana.findViewById<ImageView>(R.id.cardLiteratureSelectedImage)
    val imageBackground = ventana.findViewById<KenBurnsView>(R.id.cardLiteratureSelectedImageBack)

    //Modificaci[on de los componentes
    textViewTitle.text = literature.title
    textViewAuthor.text = literature.author
    textViewPrice.text = "$ ${literature.price}"

    //Creación del cuadro de diálogo
    val builder = AlertDialog.Builder(context)
    builder.setView(ventana)
    val alertDialog = builder.create()
    alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    //Acciones de los botones que afectan al cuadro de diálogo
    buttonBuy.setOnClickListener{ showToast(context, "Preciono el botón comprar") }
    buttonPreview.setOnClickListener { showToast(context, "Preciono el botón vista previa")}

    alertDialog.show()
}


fun showToast(context: Context, text:String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}