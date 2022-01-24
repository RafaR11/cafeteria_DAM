package com.example.cafeteria_final.menu.begudes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafeteria_final.database.producte.ProducteDao
import com.example.cafeteria_final.database.producte.ProducteEntity
import kotlinx.coroutines.launch

class BegudesViewModel(val database: ProducteDao,
                       application: Application
) : AndroidViewModel(application){

    fun listar(): List<ProducteEntity> {
            val persona = database.getBegudes()
            return persona
        }
}