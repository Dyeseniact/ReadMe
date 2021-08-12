package com.bedu.readme


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class Act6_Search: AppCompatActivity(), ItemsAdapter.ClickListener {

    private lateinit var recyclerView : RecyclerView

    val imagesName = arrayOf(
        ItemsModal("image1", "image1 desc", R.drawable.book1),
        ItemsModal("image2", "image2 desc", R.drawable.book2),
        ItemsModal("image3", "image3 desc", R.drawable.magazine1),
        ItemsModal("image4", "image4 desc", R.drawable.magazine3),
        ItemsModal("image5", "image5 desc", R.drawable.magazine2),
        ItemsModal("image6", "image6 desc", R.drawable.librodiscipulo),
        ItemsModal("image4", "image4 desc", R.drawable.magazine3),
        ItemsModal("image5", "image5 desc", R.drawable.magazine2),
        ItemsModal("image6", "image6 desc", R.drawable.librodiscipulo)
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


}