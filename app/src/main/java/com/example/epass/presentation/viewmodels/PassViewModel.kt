package com.example.epass.presentation.viewmodels

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.epass.domain.Pass
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.epass.interactors.GetPasses
import com.example.epass.interactors.InsertPass
import kotlinx.coroutines.launch

class PassViewModel(
    private val getpasses: GetPasses
) : ViewModel(), Observable
{

    val passes:LiveData<List<Pass>> =  getpasses()


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}