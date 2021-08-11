package com.bedu.readme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bedu.readme.adapters.RecyclerAdapter
import com.bedu.readme.adapters.ViewPagerRecyclerAdapter
import com.bedu.readme.models.LiteratureRV
import db.createDBBooks
import me.ibrahimsn.lib.SmoothBottomBar
import models.listBook

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

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act3_home)



        btnSearch = findViewById(R.id.act3HomeBottonSearch)

        smoothBottomBar = findViewById(R.id.act3HomeFooter)


        smoothBottomBar.setOnItemSelectedListener {
            if(it == 0){
                val intent = Intent(this,Act4_MyBooks::class.java)
                startActivity(intent)
                overridePendingTransition(0, 0)
                finish()
            }
            if (it ==2){
                Toast.makeText(this,"Aquí ejecuto el menu de ajustes",Toast.LENGTH_SHORT).show()
            }
        }





        viewpager =findViewById(R.id.act3HomeViewPagerBook)
        val literature = arrayListOf<LiteratureRV>()
        literature.add(LiteratureRV(listBook[0]!!.id,listBook[0]!!.title,listBook[0]!!.author, listBook[0]!!.genre, listBook[0]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[1]!!.id,listBook[1]!!.title,listBook[1]!!.author, listBook[1]!!.genre, listBook[1]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[2]!!.id,listBook[2]!!.title,listBook[2]!!.author, listBook[2]!!.genre, listBook[2]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[3]!!.id,listBook[3]!!.title,listBook[3]!!.author, listBook[3]!!.genre, listBook[3]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[4]!!.id,listBook[4]!!.title,listBook[4]!!.author, listBook[4]!!.genre, listBook[4]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[5]!!.id,listBook[5]!!.title,listBook[5]!!.author, listBook[5]!!.genre, listBook[5]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[6]!!.id,listBook[6]!!.title,listBook[6]!!.author, listBook[6]!!.genre, listBook[6]!!.price, "Book"))
        viewpager.adapter = ViewPagerRecyclerAdapter(this, literature)

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
        recyclerTop.adapter = RecyclerAdapter(this, literature)
        recyclerTop.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerTop.layoutManager = layoutManager

        //val firstVisibleInListview: Int = layoutManager.findFirstVisibleItemPosition()


        recyclerRecommend = findViewById(R.id.act3HomeRecyclerView3)
        recyclerRecommend.adapter = RecyclerAdapter(this,  literature)
        recyclerRecommend.setHasFixedSize(true)
        recyclerRecommend.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }
}
