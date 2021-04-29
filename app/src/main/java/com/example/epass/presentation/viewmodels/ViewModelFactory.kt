package com.example.epass.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.epass.interactors.GetPasses
import com.example.epass.interactors.InsertPass

class ViewModelFactory ( private val getPasses: GetPasses ,
                         private val insertPass: InsertPass)
    : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if ( modelClass.isAssignableFrom(PassViewModel::class.java ))
        {
            return  PassViewModel(
                getPasses
            ) as T

        }

        else if ( modelClass.isAssignableFrom(AddViewModel::class.java ))
        {
            return  AddViewModel(
                insertPass
            ) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}