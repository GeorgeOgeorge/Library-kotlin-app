package com.example.libraryapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.libraryapp.R
import com.example.libraryapp.data.model.Book
import com.example.libraryapp.data.viewModel.BookViewModel

class BookInsert : Fragment() {

    private lateinit var viewModel: BookViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_book_insert, container, false)

        viewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        view.findViewById<Button>(R.id.book_add_bt).setOnClickListener {
            viewModel.insert(Book(
                0L,
                view.findViewById<EditText>(R.id.book_tittle).text.toString(),
                view.findViewById<EditText>(R.id.book_author).text.toString(),
                view.findViewById<EditText>(R.id.book_synopsys).text.toString(),
                10.0,
                view.findViewById<EditText>(R.id.book_page_number).text.toString().toShort(),
                view.findViewById<EditText>(R.id.book_status).text.toString(),
                view.findViewById<EditText>(R.id.book_publisher).text.toString(),
                view.findViewById<EditText>(R.id.book_isbn).text.toString().toInt()
            ))
        }

        return view
    }

}