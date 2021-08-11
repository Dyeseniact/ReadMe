package com.bedu.readme

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bedu.readme.adapters.RecyclerAdapter
import com.bedu.readme.adapters.ViewPagerRecyclerAdapter
import com.google.android.material.navigation.NavigationView
import db.createDBBooks
import me.ibrahimsn.lib.SmoothBottomBar
import models.Book
import models.listBook
import java.util.ArrayList



class Act3_Home : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{


    private lateinit var recyclerBookReading : RecyclerView
    private lateinit var recyclerTop : RecyclerView
    private lateinit var recyclerRecommend : RecyclerView

    private lateinit var homeButton: ImageView
    private lateinit var settingButton: ImageView
    private lateinit var bookButton: ImageView

    private lateinit var btnSearch: ImageButton

    private lateinit var viewpager: ViewPager2

    lateinit var appBar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var smoothBottomBar :SmoothBottomBar
    lateinit var buttonAdjust :Button






    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act3_home)
        //Metodo para inflar el layout header
        var miInfladorLayout: LayoutInflater = getLayoutInflater()
        var view:View = miInfladorLayout.inflate(R.layout.drawer_header,null)
        var textEmail:TextView = view.findViewById(R.id.emailHeader)
        var textUser:TextView = view.findViewById(R.id.userHeader)
        textUser.setText("Genaro")
        textEmail.setText("correito")
        //aqui termina de inflar pero no genera cambios

        //Intento con otro metodo encontrado en intenernet
        var navigation = findViewById<NavigationView>(R.id.nav_view)
        navigation.setNavigationItemSelectedListener(this)
            //A continuacion vamos a implementar sentencia para generar los cambios en el header
        var viewNav:View = navigation.getHeaderView(0)
        var correo:TextView = viewNav.findViewById(R.id.emailHeader)
        var name:TextView = viewNav.findViewById(R.id.userHeader)
        correo.text="genaro.marcos@ine.mx"
        name.text="Hola Genaro"

        btnSearch = findViewById(R.id.act3HomeBottonSearch)

        drawerLayout = findViewById(R.id.drawer_layout)

        //aqui comenzaria la parte de la barra en donde el engrane despliega el menu



        smoothBottomBar = findViewById(R.id.act3HomeFooter)





        smoothBottomBar.setOnItemSelectedListener {
             if(it == 0){
                 val intent = Intent(this,Act4_mybook::class.java)
                 startActivity(intent)
                 finish()
             }
             if (it ==2){
                 drawerLayout.openDrawer(Gravity.START)


             }
         }



//aqui termina la funcionalidad del menu


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

    //se implementa miembo de la clase para dar clic en el navigation view
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.nav_home){


            val intent = Intent(this,Act4_mybook::class.java)
            startActivity(intent)
            finish()
        }
        return false
    }


}
