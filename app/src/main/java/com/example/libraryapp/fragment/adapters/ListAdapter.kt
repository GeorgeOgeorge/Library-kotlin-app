package com.example.libraryapp.fragment.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryapp.R
import com.example.libraryapp.data.model.Book

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var bookList = emptyList<Book>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.book_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return this.bookList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentBook = this.bookList[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.row_tittle).text = currentBook.name.toString()
            findViewById<TextView>(R.id.row_author).text = currentBook.author.toString()
        }
    }

    fun setData(books: List<Book>) {
        this.bookList = books
        notifyDataSetChanged()
    }

}