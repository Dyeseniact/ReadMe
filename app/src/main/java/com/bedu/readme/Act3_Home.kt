package com.bedu.readme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
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
import db.listUsr
import me.ibrahimsn.lib.SmoothBottomBar
import models.*

class Act3_Home : AppCompatActivity() {

    private lateinit var recyclerBookReading : RecyclerView
    private lateinit var recyclerTop : RecyclerView
    private lateinit var recyclerRecommend : RecyclerView

    private lateinit var selectGenreButton: Button

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
        val literatureNew = arrayListOf<LiteratureRV>()

        literatureNew.add(choseLiterature(0,0))
        literatureNew.add(choseLiterature(10,0))
        literatureNew.add(choseLiterature(2, 1))
        literatureNew.add(choseLiterature(3,0))
        literatureNew.add(choseLiterature(4, 2))

        viewpager.adapter = ViewPagerRecyclerAdapter(this, literatureNew)

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

        val literatureGenres = literatureRecommend(userLogin)
        recyclerTop = findViewById(R.id.act3HomeRecyclerView2)
        selectGenreButton = findViewById(R.id.act3HomeButtonSelectGenred)
        if(!literatureGenres.isEmpty()){
            recyclerTop.visibility = View.VISIBLE
            selectGenreButton.visibility = View.GONE

            recyclerTop.adapter = RecyclerAdapter(this, literatureGenres)
            recyclerTop.setHasFixedSize(true)
            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recyclerTop.layoutManager = layoutManager
        }else{
            recyclerTop.visibility = View.GONE
            selectGenreButton.visibility = View.VISIBLE
        }

        //val firstVisibleInListview: Int = layoutManager.findFirstVisibleItemPosition()

        val literatureTop = arrayListOf<LiteratureRV>()

        literatureTop.add(choseLiterature(2,0))
        literatureTop.add(choseLiterature(4,0))
        literatureTop.add(choseLiterature(8,0))
        literatureTop.add(choseLiterature(12,0))
        literatureTop.add(choseLiterature(16,0))
        literatureTop.add(choseLiterature(20,0))
        literatureTop.add(choseLiterature(24,0))
        literatureTop.add(choseLiterature(28,0))
        literatureTop.add(choseLiterature(32,0))
        literatureTop.add(choseLiterature(36,0))


        recyclerRecommend = findViewById(R.id.act3HomeRecyclerView3)
        recyclerRecommend.adapter = RecyclerAdapter(this,  literatureTop)
        recyclerRecommend.setHasFixedSize(true)
        recyclerRecommend.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }

    fun literatureRecommend(user: User) : ArrayList<LiteratureRV> {

        val literatureRecommend = arrayListOf<LiteratureRV>()
        for (i in 0 until 3){
            if(!user.preferredGenre.isEmpty()){
                val genresPreferdBooks = user.preferredGenre.elementAt(i)
                if(!genresPreferdBooks.isEmpty()){
                    when(i){
                        0-> {
                            val bookByGenresPreferd = mutableListOf<Book>()
                            listBook.forEach { val book = it
                                genresPreferdBooks.forEach { if (book?.genre == it) bookByGenresPreferd.add(book); return@forEach }
                            }
                            do{
                                val libroAleatorio = bookByGenresPreferd[(0 until bookByGenresPreferd.size).random()]
                                literatureRecommend.add( choseLiterature(libroAleatorio.id -1,0))
                            }while(literatureRecommend.size < 4)
                        }
                        1 -> {
                            val magazineByGenresPreferd = mutableListOf<Magazine>()
                            listMagazine.forEach { val magazine = it
                                genresPreferdBooks.forEach { if (magazine?.genre == it) magazineByGenresPreferd.add(magazine); return@forEach }
                            }
                            do{
                                val revistaAleatoria = magazineByGenresPreferd[(0 until magazineByGenresPreferd.size).random()]
                                literatureRecommend.add( choseLiterature(revistaAleatoria.id -1,1))
                            }while(literatureRecommend.size < 5)
                        }
                        2 ->{
                            val bookByGenresPreferd = mutableListOf<Article>()
                            listArticle.forEach { val article = it
                                genresPreferdBooks.forEach { if (article?.genre == it) bookByGenresPreferd.add(article); return@forEach }
                            }
                            do{
                                val articuloAleatorio = bookByGenresPreferd[(0 until bookByGenresPreferd.size).random()]
                                literatureRecommend.add( choseLiterature(articuloAleatorio.id -1,2))
                            }while(literatureRecommend.size < 6)
                        }
                    }
                }
            }
        }
        return literatureRecommend
    }

}
