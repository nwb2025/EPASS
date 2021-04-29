package com.example.epass.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

// represents a table
@Entity(tableName = "passes")
data class Pass(
    @PrimaryKey( autoGenerate = true) val uid:Int,
    val name:String
)