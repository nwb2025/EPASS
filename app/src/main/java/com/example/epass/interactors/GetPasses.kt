package com.example.epass.interactors

import com.example.epass.data.db.Repo

class GetPasses ( private val passesRepo: Repo) {
    operator fun invoke() = passesRepo.getAll()
}