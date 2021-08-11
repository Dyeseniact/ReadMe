package com.bedu.readme

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager


class Act6_Search: AppCompatActivity(),{

    val imagesName = arrayOf(
        ItemsModal("image1", "image1 desc", R.drawable.book1),
        ItemsModal("image2", "image2 desc", R.drawable.book2),
        ItemsModal("image3", "image3 desc", R.drawable.magazine1),
        ItemsModal("image4", "image4 desc", R.drawable.magazine3),
        ItemsModal("image5", "image5 desc", R.drawable.magazine2),
        ItemsModal("image6", "image6 desc", R.drawable.librodiscipulo)
    )

    val itemModalsList = ArrayList<ItemsModal>()
    var itemsAdapter: ItemsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act6_search)

        for(items in imagesName){
            itemModalsList.add(items)
        }

        itemsAdapter = ItemsAdapter()
        itemsAdapter!!.setData(itemModalsList)

        recyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.getDefaultSize(true)
        recyclerView.adapter = itemsAdapter



    }



}