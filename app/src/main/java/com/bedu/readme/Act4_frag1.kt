package com.bedu.readme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Act4_frag1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_act4_frag1, container, false)

        val title = view.findViewById<TextView>(R.id.frg1TitleTxtV)
        val autor= view.findViewById<TextView>(R.id.frg1AuthorTxtV)

        title.text = literatureOpen.title
        autor.text = literatureOpen.author

        return view
    }
}