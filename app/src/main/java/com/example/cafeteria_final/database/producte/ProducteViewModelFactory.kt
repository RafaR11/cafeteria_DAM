package com.example.cafeteria_final.database.producte

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cafeteria_final.database.comandes.ComandaDao
import com.example.cafeteria_final.database.comandes.ComandesViewModel

class ProducteViewModelFactory(
    private val dataSource: ProducteDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProducteViewModel::class.java)) {
            return ProducteViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}