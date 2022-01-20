package com.example.libraryapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.libraryapp.data.dao.BookDao
import com.example.libraryapp.data.model.Book

class BookRepository(private val bookDao: BookDao) {
    val bookList = MutableLiveData<List<Book>>().apply { postValue(bookDao.listAll()) }

    fun insert(book: Book) {
        this.bookDao.insert(book)
    }

    fun find(id: Long): LiveData<Book> {
        return this.bookDao.findById(id) as LiveData<Book>
    }

    fun update(book: Book) {
        this.bookDao.update(book)
    }

    fun delete(book: Book) {
        this.bookDao.delete(book)
    }
}