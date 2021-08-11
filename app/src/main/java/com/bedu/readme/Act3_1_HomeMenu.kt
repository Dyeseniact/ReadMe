package com.bedu.readme

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bedu.readme.adapters.RecyclerAdapter
import com.bedu.readme.adapters.ViewPagerRecyclerAdapter
import db.createDBBooks
import me.ibrahimsn.lib.SmoothBottomBar
import models.listBook

class Act3_1_HomeMenu : AppCompatActivity() {
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
    lateinit var smoothBottomBar : SmoothBottomBar
    lateinit var buttonAdjust :Button

    lateinit var fragmentHome:homeFragment

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act31_home_menu)

        btnSearch = findViewById(R.id.act3HomeBottonSearch)
        drawerLayout = findViewById(R.id.drawer_layout)
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



        fragmentHome = homeFragment()

        var transaccion = supportFragmentManager.beginTransaction()
        transaccion.add(R.id.fragmentContainerView,fragmentHome).commit()


/*
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

 */

    }

}