package com.example.shoestorerewrite.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeViewModel : ViewModel(){
    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList : LiveData<MutableList<Shoe>>
        get() = _shoesList

    private val interShoesList = mutableListOf<Shoe>()

    init{
        Timber.i("ShoeViewModel Created")
        saveShoe("Mine",10.5,"Adidas","My shoes")
    }
    fun saveShoe(name: String, size: Double, company: String, description: String){
        interShoesList.add(Shoe(name,size,company,description))
        _shoesList.value=interShoesList
        Timber.i("ViewModel adding a shoe $name , $size,$company, $description")
        Timber.i("Available Shoes are: ${_shoesList.value}")
    }
}