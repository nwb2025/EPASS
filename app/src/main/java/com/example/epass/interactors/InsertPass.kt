package com.example.epass.interactors

import com.example.epass.data.db.Repo
import com.example.epass.domain.Pass

class InsertPass ( private val repo: Repo)
{
    suspend operator fun invoke(pass: Pass) = repo.insertPass(pass)
}