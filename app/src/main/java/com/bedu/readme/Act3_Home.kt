package com.bedu.readme

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bedu.readme.adapters.RecyclerAdapter
import com.bedu.readme.adapters.ViewPagerRecyclerAdapter
import db.createDBBooks
import me.ibrahimsn.lib.SmoothBottomBar
import models.Book
import models.listBook
import java.util.ArrayList

class Act3_Home : AppCompatActivity() {

    private lateinit var recyclerBookReading : RecyclerView
    private lateinit var recyclerTop : RecyclerView
    private lateinit var recyclerRecommend : RecyclerView

    private lateinit var homeButton: ImageView
    private lateinit var settingButton: ImageView
    private lateinit var bookButton: ImageView

    private lateinit var btnSearch: ImageButton

    private lateinit var viewpager: ViewPager2

    private lateinit var smoothBottomBar: SmoothBottomBar

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act3_home)



        btnSearch = findViewById(R.id.act3HomeBottonSearch)

        smoothBottomBar = findViewById(R.id.act3HomeFooter)


        smoothBottomBar.setOnItemSelectedListener {
            if(it == 0){
                val intent = Intent(this,Act4_mybook::class.java)
                startActivity(intent)
                finish()
            }
            if (it ==2){
                Toast.makeText(this,"Aquí ejecuto el menu de ajustes",Toast.LENGTH_SHORT).show()
            }
        }





        createDBBooks()
        viewpager =findViewById(R.id.act3HomeViewPagerBook)
        viewpager.adapter = ViewPagerRecyclerAdapter(listBook)

        viewpager.clipToPadding = false
        viewpager.clipChildren = false
        viewpager.offscreenPageLimit = 3
        viewpager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // Define el espacio entre los slides
        val bookTransformer = CompositePageTransformer()
        bookTransformer.addTransformer(MarginPageTransformer(8))
        bookTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.95f + r * 0.05f
        }
        viewpager.setPageTransformer(bookTransformer)

        recyclerTop = findViewById(R.id.act3HomeRecyclerView2)
        recyclerTop.adapter = RecyclerAdapter(listBook)
        recyclerTop.setHasFixedSize(true)
        recyclerTop.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerRecommend = findViewById(R.id.act3HomeRecyclerView3)
        recyclerRecommend.adapter = RecyclerAdapter(listBook)
        recyclerRecommend.setHasFixedSize(true)
        recyclerRecommend.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }
}
