package com.bedu.readme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bedu.readme.ItemsAdapter.ItemsAdapterVH

class ItemsAdapter
    (var clickListener: ClickListener)
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
        holder.name.text = itemsModal.name
        holder.desc.text = itemsModal.desc
        holder.image.setImageResource(itemsModal.image)

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemsModal)
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
                    var searchChr = charSequence.toString().toLowerCase()

                    val itemModal = ArrayList<ItemsModal>()

                    for(item in itemsModalListFilter){
                        if(item.name.contains(searchChr) || item.desc.contains(searchChr)){
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