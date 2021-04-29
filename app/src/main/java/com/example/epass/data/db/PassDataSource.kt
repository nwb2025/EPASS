package com.example.epass.data.db

import androidx.lifecycle.LiveData
import com.example.epass.domain.Pass

interface PassDataSource {
    fun getAll() : LiveData<List<Pass>>

    suspend fun insertPass(pass: Pass)
}