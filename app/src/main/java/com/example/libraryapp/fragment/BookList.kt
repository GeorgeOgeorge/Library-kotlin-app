package com.example.libraryapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.R
import com.example.libraryapp.data.viewModel.BookViewModel
import com.example.libraryapp.fragment.adapters.ListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookList : Fragment() {

    private lateinit var bookViewModel: BookViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_book_list, container, false)
        val adapter = ListAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        this.bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        this.bookViewModel.bookList.observe(viewLifecycleOwner, { adapter.setData(it) })

        view.findViewById<FloatingActionButton>(R.id.add_book_bt).setOnClickListener {
            findNavController().navigate(R.id.action_bookList_to_bookInsert)
        }

        return view
    }

}