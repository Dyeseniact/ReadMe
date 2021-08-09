package com.bedu.readme.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bedu.readme.R
import com.bedu.readme.RecyclerAdapter
import com.flaviofaria.kenburnsview.KenBurnsView
import com.squareup.picasso.Picasso
import models.Book

class ViewPagerRecyclerAdapter(val literature: Array<Book?>): RecyclerView.Adapter<ViewPagerRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.cardBookTextBookName)
        val author = view.findViewById<TextView>(R.id.cardBookTextBookAuthor)
        val book = view.findViewById<KenBurnsView>(R.id.cardBookImage)

        // función bind que recibe un objeto Contact y a partir de el genera un contact_item colocando la información en le layout
        fun bind(book: Book?){
            this.name.text = book?.title ?: "Loret"
            this.author.text = book?.author ?: "Lor"
            Picasso.get().load(R.drawable.librodiscipulo).into(this.book)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        literature[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int { return literature.size }

}