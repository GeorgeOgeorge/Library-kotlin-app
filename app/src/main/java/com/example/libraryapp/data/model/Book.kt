package com.example.libraryapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
class Book(
    @PrimaryKey
    var id: Long = 0L,
    var name: String,
    var author: String,
    var synopsys: String,
    var rating: Double,
    var pageNumber: Short,
    var status: String,
    var publisher: String,
    var isbn: Int
)