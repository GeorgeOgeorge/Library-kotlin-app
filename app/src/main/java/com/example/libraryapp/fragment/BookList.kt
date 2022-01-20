package com.example.libraryapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.libraryapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)

        view.findViewById<FloatingActionButton>(R.id.add_book_bt).setOnClickListener {
            findNavController().navigate(R.id.action_bookList_to_bookInsert)
        }

        return view
    }

}