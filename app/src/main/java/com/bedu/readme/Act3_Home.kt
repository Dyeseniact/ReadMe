package com.bedu.readme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import db.createDBBooks
import models.Book
import models.listBook

class Act3_Home : AppCompatActivity() {

    private lateinit var recyclerBookReading : RecyclerView
    private lateinit var recyclerTop : RecyclerView
    private lateinit var recyclerRecommend : RecyclerView

    private lateinit var homeButton: ImageView
    private lateinit var settingButton: ImageView
    private lateinit var bookButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act3_home)

        homeButton = findViewById(R.id.IVHome)
        settingButton = findViewById(R.id.IVSettings)
        bookButton = findViewById(R.id.IVBooks)

        homeButton.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java)
            startActivity(intent)
            finish()
        }

        settingButton.setOnClickListener {
            val intent = Intent(this,Act5_Setting::class.java)
            startActivity(intent)
            finish()
        }

        bookButton.setOnClickListener {
            val intent = Intent(this,Act4_mybook::class.java)
            startActivity(intent)
            finish()
        }

        createDBBooks()
        recyclerBookReading = findViewById(R.id.act3HomeRecyclerView)
        recyclerBookReading.adapter = RecyclerAdapter(listBook)
        recyclerBookReading.setHasFixedSize(true)
        recyclerBookReading.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerBookReading.adapter = RecyclerAdapter(listBook)

        recyclerTop = findViewById(R.id.act3HomeRecyclerView2)

        recyclerTop.adapter = RecyclerAdapter(listBook)
        recyclerTop.setHasFixedSize(true)
        recyclerTop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerTop.adapter = RecyclerAdapter(listBook)

        recyclerRecommend = findViewById(R.id.act3HomeRecyclerView3)

        recyclerRecommend.adapter = RecyclerAdapter(listBook)
        recyclerRecommend.setHasFixedSize(true)
        recyclerRecommend.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerRecommend.adapter = RecyclerAdapter(listBook)


    }
}

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