package com.bedu.readme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.bedu.readme.adapters.ViewPagerBookAdapter
import com.google.android.material.tabs.TabLayout


public var viewPagerInv: ViewPager? = null

class Act4_ReadBook : AppCompatActivity() {

    var tabLayout: TabLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act4_read_book)

        //VP y TL
        viewPagerInv = findViewById(R.id.act4ReadBookViewPagerRead)
        tabLayout = findViewById(R.id.act4ReadBookTab)

        //setup del viewPager
        configuraViewPager()
        tabLayout?.setupWithViewPager(viewPagerInv)


    }

    fun configuraViewPager(){
        val adapter = ViewPagerBookAdapter(supportFragmentManager)
        adapter.addFragment(Act4_frag0(),"")
        adapter.addFragment(Act4_frag1(),"")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")
        adapter.addFragment(Act4_frag2(), "")

        viewPagerInv?.adapter = adapter
        /*if(Share.getBoolean("INVP2",false)){
            editor.remove("INVP2").apply()
            viewPager?.setCurrentItem(1,true)
        }*/
    }

}