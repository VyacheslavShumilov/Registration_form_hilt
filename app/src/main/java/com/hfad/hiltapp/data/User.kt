package com.hfad.hiltapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    val firstName: String,
    val lastname: String,
    val phone: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L
}