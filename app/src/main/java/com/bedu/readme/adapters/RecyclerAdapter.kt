package com.bedu.readme.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bedu.readme.R
import com.bedu.readme.diaglog
import com.bedu.readme.models.LiteratureRV
import com.squareup.picasso.Picasso

class RecyclerAdapter(val context: Context, val literature: ArrayList<LiteratureRV>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val nameLiterature = view.findViewById<TextView>(R.id.rv_title_lecture)
        val authorLiterature = view.findViewById<TextView>(R.id.rv_author_lecture)
        val imageLiterature = view.findViewById<ImageView>(R.id.rv_image)
        val vistaClick = view.findViewById<CardView>(R.id.card_rv_book)

        // función bind que recibe un objeto Contact y a partir de el genera un contact_item colocando la información en le layout
        fun bind(literarure: LiteratureRV){
            nameLiterature.text = literarure.title
            authorLiterature.text = literarure.author
            if(literarure.image != "" ){ Picasso.get().load(literarure.image).into(this.imageLiterature)  }
        }
    }

    //Cuando no se puede reciclar, lo que hace es llamar al método para crear uno nuevo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_rv_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(literature[position])

        holder.vistaClick.setOnClickListener { diaglog(context,LayoutInflater.from(context), literature[position]) }

    }

    override fun getItemCount(): Int {
        return literature.size
    }
}