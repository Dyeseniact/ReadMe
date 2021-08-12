package com.bedu.readme

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bedu.readme.adapters.RecyclerAdapter
import com.bedu.readme.models.LiteratureRV
import me.ibrahimsn.lib.SmoothBottomBar
import models.listBook
import java.util.ArrayList

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
                Toast.makeText(this,"Aquí ejecuto el menu de ajustes", Toast.LENGTH_SHORT).show()
            }
        }

        //Slider para libros
        val textBookView = findViewById<TextView>(R.id.textView_book)
        val bookView = findViewById<ViewPager2>(R.id.slider_books)
        val bookSlider: MutableList<HomeCard> = ArrayList()

        val book1 = HomeCard()
        book1.book_image = R.drawable.book1
        book1.downloads = "200k"
        bookSlider.add(book1)

        val book2 = HomeCard()
        book2.book_image = R.drawable.book2
        book2.downloads = "150k"
        bookSlider.add(book2)

        val book3 = HomeCard()
        book3.book_image = R.drawable.librodiscipulo
        book3.downloads = "140k"
        bookSlider.add(book3)

        val book4 = HomeCard()
        book4.book_image = R.drawable.book2
        book4.downloads = "130k"
        bookSlider.add(book4)

        bookView.adapter = Act_HomeCardAdapter(bookSlider)
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

        val literature = arrayListOf<LiteratureRV>()
        literature.add(LiteratureRV(listBook[0]!!.id, listBook[0]!!.title, listBook[0]!!.author, listBook[0]!!.genre, listBook[0]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[1]!!.id, listBook[1]!!.title, listBook[1]!!.author, listBook[1]!!.genre, listBook[1]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[2]!!.id, listBook[2]!!.title, listBook[2]!!.author, listBook[2]!!.genre, listBook[2]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[3]!!.id, listBook[3]!!.title, listBook[3]!!.author, listBook[3]!!.genre, listBook[3]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[4]!!.id, listBook[4]!!.title, listBook[4]!!.author, listBook[4]!!.genre, listBook[4]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[5]!!.id, listBook[5]!!.title, listBook[5]!!.author, listBook[5]!!.genre, listBook[5]!!.price, "Book"))
        literature.add(LiteratureRV(listBook[6]!!.id, listBook[6]!!.title, listBook[6]!!.author, listBook[6]!!.genre, listBook[6]!!.price, "Book"))

        recyclerMiLiterature = findViewById(R.id.act4MyBooksRVMibiblioteca)
        recyclerMiLiterature.adapter = RecyclerAdapter(this, literature)
        recyclerMiLiterature.setHasFixedSize(true)

        recyclerMiLiterature.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL,false)

        recyclerMiLiterature.setOnScrollChangeListener { view, scrollx, scrolly, oldScrollx, oldScrolly ->
            if (  scrolly > oldScrolly && flagOne  ){
                textBookView.visibility = View.GONE
                bookView.visibility = View.GONE
                flagOne = false
            }

        }



    }

}