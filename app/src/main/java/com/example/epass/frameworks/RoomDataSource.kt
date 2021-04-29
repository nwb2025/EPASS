package com.example.epass.frameworks

import androidx.lifecycle.LiveData
import com.example.epass.data.db.PassDataSource
import com.example.epass.domain.Pass
import com.example.epass.data.db.DAO

class RoomDataSource(private val dao:DAO?) :
    PassDataSource {
    override fun getAll(): LiveData<List<Pass>> = dao?.getAll()!!

    override suspend fun insertPass(pass: Pass) {
        dao?.addPass(pass)
    }
}