package com.bedu.readme

import android.app.Activity
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
import com.bedu.readme.models.LiteratureRV
import com.flaviofaria.kenburnsview.KenBurnsView
import com.squareup.picasso.Picasso
import models.listArticle
import models.listBook
import models.listMagazine


fun diaglog(context: Context, activity: Activity, inflater: LayoutInflater, literature: LiteratureRV){
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
    if(literature.image != "" ){ Picasso.get().load(literature.image).into(imageView)  }
    if(literature.image != "" ){ Picasso.get().load(literature.image).into(imageBackground)  }
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

        val intent = Intent(activity.applicationContext,Act_Pagar::class.java).apply {
            putExtras(Compra)


        }
        activity.startActivity(intent)



    }







    buttonPreview.setOnClickListener { showToast(activity, "Preciono el botón vista previa")}

    alertDialog.show()
}


fun showToast(context: Context, text:String){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}

fun choseLiterature( numLiterature: Int , type: Int): LiteratureRV {
    when( type ){
        0 -> {
            val lit = listBook[numLiterature]
            return LiteratureRV(lit!!.id,lit.title,lit.author, lit.genre, lit.price, lit.image,"Book")
        }
        1 -> {
            val lit = listMagazine[numLiterature];
            return LiteratureRV(lit!!.id,lit.title,lit.author, lit.genre, lit.price, lit.image,"Magazine")
        }
        else -> {
            val lit = listArticle[numLiterature];
            return LiteratureRV(lit!!.id,lit.title,lit.author, lit.genre, lit.price, lit.image,"Articule")
        }
    }
}

fun returnMyPreferences(genresSelected:String): MutableSet<String> {
    val bus = arrayListOf<Int>(); for(x in 0 until genresSelected.length){ if(genresSelected.substring(x,x+1)==","){ bus.add(x) } }
    val list = mutableSetOf<String>()
    if(!bus.isEmpty()){
        for (i in 0 until bus.size-1){
            if(genresSelected.substring(bus[i]+2, bus[i+1] ) != ""){
                list.add(genresSelected.substring(bus[i]+2, bus[i+1] ))
            }

        }
    }
    return list

}

fun isEmailValid(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}