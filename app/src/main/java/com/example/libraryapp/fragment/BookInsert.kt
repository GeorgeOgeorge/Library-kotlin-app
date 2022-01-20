package com.example.libraryapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.libraryapp.R
import com.example.libraryapp.data.model.Book
import com.example.libraryapp.data.viewModel.BookViewModel

class BookInsert : Fragment() {

    private lateinit var viewModel: BookViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_book_insert, container, false)
        this.viewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        //insert book function
        view.findViewById<Button>(R.id.book_add_bt).setOnClickListener {
            viewModel.insert(getBook(view))
            findNavController().navigate(R.id.action_bookInsert_to_bookList)
            Toast.makeText(context,"Book added", Toast.LENGTH_LONG).show()
        }

        return view
    }

    // TODO input check
    private fun getBook(view: View): Book {
        return Book(
            0,
            view.findViewById<EditText>(R.id.book_tittle).text.toString(),
            view.findViewById<EditText>(R.id.book_author).text.toString(),
            view.findViewById<EditText>(R.id.book_synopsys).text.toString(),
            10.0,
            view.findViewById<EditText>(R.id.book_page_number).text.toString().toShort(),
            view.findViewById<EditText>(R.id.book_status).text.toString(),
            view.findViewById<EditText>(R.id.book_publisher).text.toString(),
            view.findViewById<EditText>(R.id.book_isbn).text.toString().toInt()
        )
    }

}