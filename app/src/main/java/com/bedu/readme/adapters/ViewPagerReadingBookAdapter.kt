package com.bedu.readme.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bedu.readme.models.myLiteratureCard
import com.bedu.readme.R
import com.flaviofaria.kenburnsview.KenBurnsView
import com.squareup.picasso.Picasso

class ViewPagerReadingBookAdapter(private val cardAdapter: MutableList<myLiteratureCard>) :
    RecyclerView.Adapter<ViewPagerReadingBookAdapter.CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_cards_home, parent, false))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.setLocationData(cardAdapter[position])
    }

    override fun getItemCount(): Int {
        return cardAdapter.size
    }

    class CardViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        private val kbvLocation: KenBurnsView
        private val textTitle: TextView

        fun setLocationData(HomeCard: myLiteratureCard) {
            HomeCard.book_image?.let { Picasso.get().load(it).into(kbvLocation) }
            HomeCard.book_image2 ?.let { Picasso.get().load(it).into(kbvLocation) }
            textTitle.text = HomeCard.downloads
        }

        init {
            kbvLocation = itemView.findViewById(R.id.kbvLocation)
            textTitle = itemView.findViewById(R.id.textDowloads)
        }
    }
}