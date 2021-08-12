package com.bedu.readme.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bedu.readme.R
import com.bedu.readme.diaglog
import com.bedu.readme.models.LiteratureRV
import com.flaviofaria.kenburnsview.KenBurnsView
import com.squareup.picasso.Picasso

class ViewPagerRecyclerAdapter(val context:Context, val literature: ArrayList<LiteratureRV>): RecyclerView.Adapter<ViewPagerRecyclerAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.cardBookTextBookName)
        val author = view.findViewById<TextView>(R.id.cardBookTextBookAuthor)
        val book = view.findViewById<KenBurnsView>(R.id.cardBookImage)

        val vistaClick = view.findViewById<CardView>(R.id.card_book)

        // función bind que recibe un objeto Contact y a partir de el genera un contact_item colocando la información en le layout
        fun bind(book: LiteratureRV){
            this.name.text = book?.title ?: "Loret"
            this.author.text = book?.author ?: "Lor"
            Picasso.get().load(R.drawable.librodiscipulo).into(this.book)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_vp_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        literature[position]?.let { holder.bind(it) }

        holder.vistaClick.setOnClickListener { diaglog(context,LayoutInflater.from(context), literature[position])  }

    }

    override fun getItemCount(): Int { return literature.size }

}