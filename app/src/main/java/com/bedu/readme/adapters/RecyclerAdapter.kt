package com.bedu.readme.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bedu.readme.R
import models.Book

class RecyclerAdapter(val literature: Array<Book?>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val nameLitetarute = view.findViewById<TextView>(R.id.rv_title_lecture)

        // función bind que recibe un objeto Contact y a partir de el genera un contact_item colocando la información en le layout
        fun bind(name: String){
            nameLitetarute.text = name
        }
    }

    //Cuando no se puede reciclar, lo que hace es llamar al método para crear uno nuevo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_books, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(literature[position]!!.title)
    }

    override fun getItemCount(): Int {
        return literature.size
    }
}