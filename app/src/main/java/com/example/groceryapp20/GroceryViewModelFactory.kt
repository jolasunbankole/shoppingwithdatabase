package com.example.groceryapp20

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GroceryViewModelFactory
    (private val repository: GroceryRepo) : ViewModelProvider.NewInstanceFactory(){

    override fun <T: ViewModel?> create(modelClass: Class<T>): T{
        return GroceryViewModel(repository) as T
    }
}