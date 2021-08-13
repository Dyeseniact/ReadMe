package com.bedu.readme.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bedu.readme.models.ItemsModal
import com.bedu.readme.R
import com.bedu.readme.adapters.ItemsAdapter.ItemsAdapterVH
import com.bedu.readme.diaglog
import com.bedu.readme.models.LiteratureRV
import com.squareup.picasso.Picasso

class ItemsAdapter
    (val context: Context,
     val activity: Activity)
    : RecyclerView.Adapter<ItemsAdapterVH>(), Filterable {

    var itemsModalList = ArrayList<ItemsModal>()
    var itemsModalListFilter = ArrayList<ItemsModal>()

    fun setData(itemsModalList: ArrayList<ItemsModal>) {
        this.itemsModalList = itemsModalList
        this.itemsModalListFilter = itemsModalList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return  ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent, false))
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {

        val itemsModal = itemsModalList[position]
        holder.name.text = itemsModal.title
        holder.desc.text = itemsModal.author
        Picasso.get().load(itemsModal.image).into(holder.image)


        holder.itemView.setOnClickListener{
            diaglog(context, activity, LayoutInflater.from(activity), LiteratureRV(
                itemsModal.id,
                itemsModal.title,
                itemsModal.author,
                itemsModal.genre,
                itemsModal.price,
                itemsModal.image,
                itemsModal.typeLiteraure
            ))
        }

    }

    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView){

        val name = itemView.findViewById<TextView>(R.id.textView_name)
        val desc = itemView.findViewById<TextView>(R.id.textView_desc)
        val image = itemView.findViewById<ImageView>(R.id.imageView_search)


    }

    interface ClickListener {
        fun ClickedItem(itemsModal: ItemsModal)
    }

    override fun getFilter(): Filter {
        return object: Filter(){
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResult = FilterResults()
                if(charSequence == null || charSequence.length < 0){
                    filterResult.count = itemsModalListFilter.size
                    filterResult.values = itemsModalListFilter

                }else {
                    var searchChr = charSequence.toString()

                    val itemModal = ArrayList<ItemsModal>()

                    for(item in itemsModalListFilter){
                        if(item.title.contains(searchChr) || item.author.contains(searchChr)){
                            itemModal.add(item)
                        }
                    }
                    filterResult.count = itemModal.size
                    filterResult.values = itemModal
                }
                return filterResult
            }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {
                itemsModalList = filterResults!!.values as ArrayList<ItemsModal>
                notifyDataSetChanged()
            }

        }
    }
}