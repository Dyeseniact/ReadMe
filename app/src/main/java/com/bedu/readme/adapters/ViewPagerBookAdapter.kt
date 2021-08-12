package com.bedu.readme.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
//Esta clase sirve para que el navigation bottom bar pueda mostrar los diferentes fragments
class ViewPagerBookAdapter(fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager) {

    //Necesitamos crear un arraylist de fragmentos
    var fragmentList:ArrayList<Fragment>?= null

    //Titulos de fragmentos
    var fragmentTitleList:ArrayList<String>?= null

    init {
        fragmentList = ArrayList()
        fragmentTitleList = ArrayList()
    }


    override fun getItem(position: Int): Fragment {
       return fragmentList?.get(position)!!
    }

    override fun getCount(): Int {
        return  fragmentList?.size!!
    }

    fun addFragment(fragment: Fragment, titulo:String){
        fragmentList?.add(fragment)!!
        fragmentTitleList?.add(titulo)!!
    }

    //Despligue de títulos
    override fun getPageTitle(position: Int): String {
        return fragmentTitleList?.get(position)!!
    }
}