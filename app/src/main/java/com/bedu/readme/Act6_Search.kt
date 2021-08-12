package com.bedu.readme


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class Act6_Search: AppCompatActivity(), ItemsAdapter.ClickListener {

    private lateinit var recyclerView : RecyclerView

    val imagesName = arrayOf(
        ItemsModal("Bajo la misma estrella", "John Green", R.drawable.book1),
        ItemsModal("1984", "George Orwell", R.drawable.book2),
        ItemsModal("Historia", "National Geographic", R.drawable.magazine1),
        ItemsModal("Arte", "National Geographic", R.drawable.magazine3),
        ItemsModal("Historia Neron", "National Geographic", R.drawable.magazine2),
        ItemsModal("El discipulo", "Angelo Scotti", R.drawable.librodiscipulo),
        ItemsModal("Bajo la misma estrella", "John Green", R.drawable.book1),
        ItemsModal("1984", "George Orwell", R.drawable.book2),
        ItemsModal("Historia", "National Geographic", R.drawable.magazine1),
        ItemsModal("Arte", "National Geographic", R.drawable.magazine3),
        ItemsModal("Historia Neron", "National Geographic", R.drawable.magazine2)


    )

    private val itemModalsList = ArrayList<ItemsModal>()
    var itemsAdapter: ItemsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act6_search)



        for(items in imagesName){
            itemModalsList.add(items)
        }

        itemsAdapter = ItemsAdapter(this)
        itemsAdapter!!.setData(itemModalsList)

        recyclerView = findViewById(R.id.recyclerView_search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = itemsAdapter



    }

    override fun ClickedItem(itemsModal: ItemsModal) {
        Log.e("TAG",itemsModal.name)

        when( itemsModal.name){
            "image1" ->
                startActivity(Intent(this@Act6_Search, Act4_MyBooks::class.java))
            else -> {
                Toast.makeText(this, "No actions", Toast.LENGTH_LONG).show()
            }
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


