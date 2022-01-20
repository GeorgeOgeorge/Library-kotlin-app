package com.example.libraryapp.data.dao

import androidx.room.*
import com.example.libraryapp.data.model.Book

@Dao
interface BookDao {
    @Insert
    fun insert(book: Book): Long

    @Delete
    fun delete(book: Book): Int

    @Update
    fun update(book: Book): Int

    @Query("SELECT * FROM book")
    fun listAll(): List<Book>

    @Query("SELECT * FROM book WHERE id = :id")
    fun findById(id: Long): Book
}