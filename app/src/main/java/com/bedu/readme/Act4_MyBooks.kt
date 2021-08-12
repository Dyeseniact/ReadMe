package com.bedu.readme

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bedu.readme.adapters.RecyclerAdapter
import com.bedu.readme.adapters.myBooksCardAdapter
import com.bedu.readme.models.myLiteratureCard
import com.bedu.readme.models.LiteratureRV
import db.listUsr
import com.google.android.material.navigation.NavigationView
import db.listUsr
import me.ibrahimsn.lib.SmoothBottomBar
import models.listArticle
import models.listBook
import java.util.ArrayList

class Act4_MyBooks : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var smoothBottomBar: SmoothBottomBar
    private lateinit var recyclerMiLiterature: RecyclerView
    private lateinit var btnSearch: ImageButton

    var flagOne = true

    @SuppressLint("WrongConstant")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(saveWomenInstanceState: Bundle?) {
        super.onCreate(saveWomenInstanceState)
        setContentView(R.layout.activity_act4_mybooks)

        //Se infla la vista
        var navigation = findViewById<NavigationView>(R.id.nav_view)
        navigation.setNavigationItemSelectedListener(this)
        //A continuacion vamos a implementar sentencia para generar los cambios en el header
        var viewNav: View = navigation.getHeaderView(0)
        var correo: TextView = viewNav.findViewById(R.id.emailHeader)
        var name:TextView = viewNav.findViewById(R.id.userHeader)
        var imagen: ImageView = viewNav.findViewById(R.id.imageHeader)


        when(currentCount){
            0->imagen.setImageResource(R.drawable.erick)
            1->imagen.setImageResource(R.drawable.yess)
            2->imagen.setImageResource(R.drawable.janner)
            3->imagen.setImageResource(R.drawable.genaro)
            else -> imagen.setImageResource(R.drawable.img)
        }

        var drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        smoothBottomBar = findViewById(R.id.act4MyBooksFooter)

        smoothBottomBar.setOnItemSelectedListener {
            if(it == 0){
                val intent = Intent(this,Act4_MyBooks::class.java)
                startActivity(intent)
                overridePendingTransition(0, 0)
            }
            if(it == 1){
                val intent = Intent(this,Act3_Home::class.java)
                startActivity(intent)
                overridePendingTransition(0, 0)
            }
            if (it ==2){
                Handler().postDelayed({
                    smoothBottomBar.itemActiveIndex = 0
                    Toast.makeText(this,"Aquí ejecuto el menu de ajustes", Toast.LENGTH_SHORT).show()
                }, 200)
                drawerLayout.openDrawer(Gravity.START)
                println("el user es ${listUsr[currentCount]?.userName} la cuenta va en $currentCount")
                correo.text= listUsr[currentCount]?.getEmail()
                name.text= listUsr[currentCount]?.userName
            }
        }

        //Slider para libros
        val textBookView = findViewById<TextView>(R.id.textView_book)
        val bookView = findViewById<ViewPager2>(R.id.slider_books)
        val bookSlider: MutableList<myLiteratureCard> = ArrayList()

        val book1 = myLiteratureCard()
        //Picasso.get().load(R.drawable.librodiscipulo).into(this.book)
        //https://i.redd.it/3mkuta0m4c351.png
        book1.book_image2 = "https://i.redd.it/3mkuta0m4c351.png"
        book1.downloads = "200k"
        bookSlider.add(book1)

        val book2 = myLiteratureCard()
        book2.book_image = R.drawable.book2
        book2.downloads = "150k"
        bookSlider.add(book2)

        val book3 = myLiteratureCard()
        book3.book_image = R.drawable.librodiscipulo
        book3.downloads = "140k"
        bookSlider.add(book3)

        val book4 = myLiteratureCard()
        book4.book_image = R.drawable.book2
        book4.downloads = "130k"
        bookSlider.add(book4)

        bookView.adapter = myBooksCardAdapter(bookSlider)
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
        for (i in 0 until 3){
            val ip = i
            val lit = listBook[ip]
            literature.add(LiteratureRV(lit!!.id,lit.title,lit.author, lit.genre, lit.price, lit.image,"Book"))
        }
        recyclerMiLiterature = findViewById(R.id.act4MyBooksRVMibiblioteca)
        recyclerMiLiterature.adapter = RecyclerAdapter(this, literature)
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


    //se implementa miembo de la clase para dar clic en el navigation view
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.nav_home){
            val intent = Intent(this,Act_userCount::class.java)
            startActivity(intent)

        }
        if(item.itemId==R.id.nav_payment){
            val intent = Intent(this,Act_card::class.java)
            startActivity(intent)

        }

        if(item.itemId==R.id.nav_about){
            val intent = Intent(this,Act_acercaDe::class.java)
            startActivity(intent)
        }
        if(item.itemId==R.id.nav_privacy){
            val intent = Intent(this,Act_privacy::class.java)
            startActivity(intent)
        }
        return false
    }

}