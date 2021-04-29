package com.example.epass.presentation.viewmodels

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epass.domain.Pass
import com.example.epass.interactors.InsertPass
import kotlinx.coroutines.launch

class AddViewModel (
    private val insertPass: InsertPass )
    : ViewModel(), Observable
{
    @Bindable
    val n =  MutableLiveData<String>()


    fun insertPass(name:String){
        viewModelScope.launch {
            if( name != null )
                insertPass( Pass(0, name) )
        }
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}