package com.bedu.readme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import java.util.ArrayList

class Act_HomeNew : AppCompatActivity() {

    override fun onCreate(saveWomenInstanceState: Bundle?) {
        super.onCreate(saveWomenInstanceState)
        setContentView(R.layout.activity_home_new)

        //Slider para libros
        val bookView = findViewById<ViewPager2>(R.id.slider_books)
        val bookSlider: MutableList<HomeCard> = ArrayList()

        val book1 = HomeCard()
        book1.book_image = R.drawable.book1
        book1.downloads = "200k"
        bookSlider.add(book1)

        val book2 = HomeCard()
        book2.book_image = R.drawable.book2
        book2.downloads = "150k"
        bookSlider.add(book2)

        val book3 = HomeCard()
        book3.book_image = R.drawable.librodiscipulo
        book3.downloads = "140k"
        bookSlider.add(book3)

        val book4 = HomeCard()
        book4.book_image = R.drawable.book2
        book4.downloads = "130k"
        bookSlider.add(book4)

        bookView.adapter = Act_HomeCardAdapter(bookSlider)
        bookView.clipToPadding = false
        bookView.clipChildren = false
        bookView.offscreenPageLimit = 3
        bookView.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        // Define el espacio entre los slides
        val bookTransformer = CompositePageTransformer()
        bookTransformer.addTransformer(MarginPageTransformer(8))
        bookTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.95f + r * 0.05f
        }
        bookView.setPageTransformer(bookTransformer)

        // Slider para Revistas
        val magazineView = findViewById<ViewPager2>(R.id.slider_magazine)
        val magazineSlider: MutableList<HomeCard> = ArrayList()

        val magazine1 = HomeCard()
        magazine1.book_image = R.drawable.magazine1
        magazine1.downloads = "50k "
        magazineSlider.add(magazine1)

        val magazine2 = HomeCard()
        magazine2.book_image = R.drawable.magazine2
        magazine2.downloads = "30k"
        magazineSlider.add(magazine2)

        val magazine3 = HomeCard()
        magazine3.book_image = R.drawable.magazine3
        magazine3.downloads = "20k"
        magazineSlider.add(magazine3)

        val magazine4 = HomeCard()
        magazine4.book_image = R.drawable.magazine1
        magazine4.downloads = "10k"
        magazineSlider.add(magazine4)

        magazineView.adapter = Act_HomeCardAdapter(magazineSlider)
        magazineView.clipToPadding = false
        magazineView.clipChildren = false
        magazineView.offscreenPageLimit = 3
        magazineView.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositeMenPageTransformer = CompositePageTransformer()
        compositeMenPageTransformer.addTransformer(MarginPageTransformer(8))
        compositeMenPageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.95f + r * 0.05f
        }
        magazineView.setPageTransformer(compositeMenPageTransformer)

        //Slider para Artículos
        val articleView = findViewById<ViewPager2>(R.id.slider_article)
        val articleSlide: MutableList<HomeCard> = ArrayList()

        val article1 = HomeCard()
        article1.book_image = R.drawable.book1
        article1.downloads = "100k"
        articleSlide.add(article1)

        val article2 = HomeCard()
        article2.book_image = R.drawable.book1
        article2.downloads = "90k"
        articleSlide.add(article2)

        val article3 = HomeCard()
        article3.book_image = R.drawable.book1
        article3.downloads = "80k"
        articleSlide.add(article3)

        val article4 = HomeCard()
        article4.book_image = R.drawable.book1
        article4.downloads = "70k"
        articleSlide.add(article4)

        articleView.adapter = Act_HomeCardAdapter(articleSlide)
        articleView.clipToPadding = false
        articleView.clipChildren = false
        articleView.offscreenPageLimit = 3
        articleView.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositeKidPageTransformer = CompositePageTransformer()
        compositeKidPageTransformer.addTransformer(MarginPageTransformer(8))
        compositeKidPageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.95f + r * 0.05f
        }
        articleView.setPageTransformer(compositeKidPageTransformer)
    }

}