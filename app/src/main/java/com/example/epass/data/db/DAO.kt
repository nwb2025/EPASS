package com.example.epass.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.epass.domain.Pass

@Dao
interface DAO {
    @Query("SELECT * FROM passes")
    fun getAll() : LiveData<List<Pass>>

    @Insert
    suspend fun addPass(pass : Pass)

    @Delete
    suspend fun deletePass(pass: Pass)

    @Query("UPDATE passes SET name = :name WHERE uid = :id")
    suspend fun updateDoneDates(name:String , id:String )
}