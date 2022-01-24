package com.example.cafeteria_final.menu.postres

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cafeteria_final.database.producte.ProducteDao
import com.example.cafeteria_final.database.producte.ProducteEntity

class PostresViewModel(val database: ProducteDao,
                       application: Application
) : AndroidViewModel(application){

    fun listar(): List<ProducteEntity> {
        val postres = database.getPostres()
        return postres
    }
}