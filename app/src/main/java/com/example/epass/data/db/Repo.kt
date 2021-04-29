package com.example.epass.data.db

import androidx.lifecycle.LiveData
import com.example.epass.data.db.PassDataSource
import com.example.epass.domain.Pass

class Repo ( private val dataSource: PassDataSource) {
    fun getAll() : LiveData<List<Pass>> = dataSource.getAll()

    suspend fun insertPass(pass: Pass) = dataSource.insertPass(pass)
}