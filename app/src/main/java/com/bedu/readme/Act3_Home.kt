package com.bedu.readme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Act3_Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act3_home)
    }
}

class RecyclerAdapter(val literature : List<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

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
        holder.bind(literature[position])
    }

    override fun getItemCount(): Int {
        return literature.size
    }
}