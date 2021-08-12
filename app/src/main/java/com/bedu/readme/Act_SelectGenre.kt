package com.bedu.readme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout

class Act_SelectGenre : AppCompatActivity() {

   private lateinit var TabLayout: TabLayout
   private lateinit var ViewPager: ViewPager




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_select_genre)

        TabLayout = findViewById(R.id.tabFiccion)
        ViewPager = findViewById(R.id.viewPager)
    }
}