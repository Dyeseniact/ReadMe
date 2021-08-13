package com.bedu.readme


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bedu.readme.adapters.ItemsAdapter
import com.bedu.readme.models.ItemsModal
import models.listBook


class Act6_Search: AppCompatActivity(), ItemsAdapter.ClickListener {

    private lateinit var recyclerView : RecyclerView

    val imagesName = arrayOf<ItemsModal>()


    private val itemModalsList = ArrayList<ItemsModal>()
    var itemsAdapter: ItemsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act6_search)

        listBook.forEach {

            itemModalsList.add(ItemsModal(it!!.id, it.title, it.author, it.genre, it.price, it.image, "book"))
        }


        itemsAdapter = ItemsAdapter(this,this)
        itemsAdapter!!.setData(itemModalsList)

        recyclerView = findViewById(R.id.recyclerView_search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemsAdapter

    }

    override fun ClickedItem(itemsModal: ItemsModal) {
        Log.e("TAG",itemsModal.title)
        when( itemsModal.title){

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_search, menu)

        val menuItem = menu!!.findItem(R.id.searchView)

        val searchView = menuItem.actionView as SearchView

        searchView.maxWidth = Int.MAX_VALUE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(filterString: String?): Boolean {

                itemsAdapter!!.filter.filter(filterString)
                return true
            }

            override fun onQueryTextChange(filterString: String?): Boolean {

                itemsAdapter!!.filter.filter(filterString)
                return true
            }

        })

        return true;
    }



}


