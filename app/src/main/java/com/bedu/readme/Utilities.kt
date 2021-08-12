package com.bedu.readme

import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import com.bedu.readme.models.LiteratureRV
import com.flaviofaria.kenburnsview.KenBurnsView
import java.security.AccessController.getContext


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
    textViewPrice.text = "${literature.price}"

    //Creación del cuadro de diálogo
    val builder = AlertDialog.Builder(context)
    builder.setView(ventana)
    val alertDialog = builder.create()
    alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))







    //Acciones de los botones que afectan al cuadro de diálogo
    buttonBuy.setOnClickListener{
        val Compra = Bundle()
//        val Precio = Bundle()

       Compra.putString("Titulo",literature.title)
       Compra.putString("Precio", "${literature.price}")

        val intent = Intent(context,Act_Pagar::class.java).apply {
            putExtras(Compra)


        }
        context.applicationContext.startActivity(intent)



    }







    buttonPreview.setOnClickListener { showToast(context, "Preciono el botón vista previa")}

    alertDialog.show()
}



fun showToast(context: Context, text:String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}