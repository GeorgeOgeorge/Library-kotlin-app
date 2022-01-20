package com.example.libraryapp.data.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.libraryapp.data.database.BookDatabase
import com.example.libraryapp.data.model.Book
import com.example.libraryapp.data.repository.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {

    var bookList: LiveData<List<Book>>
    private var repository: BookRepository

    init {
        val bookDao = BookDatabase.getDatabase(application).bookDao()
        this.repository = BookRepository(bookDao)
        this.bookList = this.repository.bookList
    }

    fun insert(book: Book) {
        viewModelScope.launch(Dispatchers.IO) { repository.insert(book) }
    }

    fun update(book: Book) {
        viewModelScope.launch(Dispatchers.IO) { repository.update(book) }
    }

    fun delete(book: Book) {
        viewModelScope.launch(Dispatchers.IO) { repository.delete(book) }
    }

}