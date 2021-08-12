package com.bedu.readme

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bedu.readme.adapters.RecyclerAdapterShowBooksHorizontal
import com.bedu.readme.adapters.ViewPagerShowBooksRecyclerAdapter
import com.bedu.readme.models.myLiteratureCard
import com.bedu.readme.models.LiteratureRV
import me.ibrahimsn.lib.SmoothBottomBar
import models.listBook
import java.util.ArrayList

lateinit var literatureOpen: LiteratureRV

class Act4_MyBooks : AppCompatActivity() {

    private lateinit var smoothBottomBar: SmoothBottomBar
    private lateinit var recyclerMiLiterature: RecyclerView

    var flagOne = true

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(saveWomenInstanceState: Bundle?) {
        super.onCreate(saveWomenInstanceState)
        setContentView(R.layout.activity_act4_mybooks)

        smoothBottomBar = findViewById(R.id.act4MyBooksFooter)

        smoothBottomBar.setOnItemSelectedListener {
            if(it == 1){
                val intent = Intent(this,Act3_Home::class.java)
                startActivity(intent)
                overridePendingTransition(0, 0)
                finish()
            }
            if (it ==2){
                Handler().postDelayed({
                    smoothBottomBar.itemActiveIndex = 0
                    Toast.makeText(this,"Aquí ejecuto el menu de ajustes", Toast.LENGTH_SHORT).show()
                }, 200)
            }
        }

        //Slider para libros
        val textBookView = findViewById<TextView>(R.id.textView_book)
        val bookView = findViewById<ViewPager2>(R.id.slider_books)
        val bookSlider: MutableList<myLiteratureCard> = ArrayList()

        val literature = arrayListOf<LiteratureRV>()
        for (i in 0 until 3){
            val ip = i
            val lit = listBook[ip]
            literature.add(LiteratureRV(lit!!.id,lit.title,lit.author, lit.genre, lit.price, lit.image,"Book", true))
        }


        bookView.adapter = ViewPagerShowBooksRecyclerAdapter(this, this, literature, ::openBookToRead)
        bookView.clipToPadding = false
        bookView.clipChildren = false
        bookView.offscreenPageLimit = 3
        bookView.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // Define el espacio entre los slides
        val bookTransformer = CompositePageTransformer()
        bookTransformer.addTransformer(MarginPageTransformer(8))
        bookTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.95f + r * 0.05f
        }
        bookView.setPageTransformer(bookTransformer)

        recyclerMiLiterature = findViewById(R.id.act4MyBooksRVMibiblioteca)
        recyclerMiLiterature.adapter = RecyclerAdapterShowBooksHorizontal(this, this, literature, ::openBookToRead)
        recyclerMiLiterature.setHasFixedSize(true)

        recyclerMiLiterature.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL,false)

        recyclerMiLiterature.setOnScrollChangeListener { view, scrollx, scrolly, oldScrollx, oldScrolly ->
            if (  scrolly > oldScrolly && flagOne  ){
                bookView.visibility = View.GONE
                flagOne = false
            }


            if (  oldScrolly > scrolly  && textBookView.visibility == View.GONE   ){
                textBookView.visibility = View.VISIBLE
                bookView.visibility = View.VISIBLE
                flagOne = true
            }


        }
    }

    fun openBookToRead(literature:LiteratureRV? = null){
        literatureOpen = literature!!
        val intent = Intent(this,Act4_ReadBook::class.java)
        startActivity(intent)
    }

}