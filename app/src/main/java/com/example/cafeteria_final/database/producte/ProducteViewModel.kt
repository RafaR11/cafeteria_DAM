package com.example.cafeteria_final.database.producte

import android.app.Application
import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafeteria_final.database.usuari.UsuariDao
import com.example.cafeteria_final.database.usuari.UsuariEntity
import kotlinx.coroutines.launch

class ProducteViewModel(val database: ProducteDao,
                      application: Application
) : AndroidViewModel(application){


    fun insert(producte: ProducteEntity) = viewModelScope.launch {
        database.insert(producte);
    }
}
