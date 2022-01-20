package com.example.libraryapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
class Book(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
    var author: String,
    var synopsys: String,
    var rating: Double,
    var pageNumber: Short,
    var status: String,
    var publisher: String,
    var isbn: Int
)