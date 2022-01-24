package com.example.cafeteria_final.menu.postres

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cafeteria_final.database.producte.ProducteDao
import com.example.cafeteria_final.menu.begudes.PrimersViewModel

class PostresViewModelFactory(
    private val dataSource: ProducteDao,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostresViewModel::class.java)) {
            return PostresViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}