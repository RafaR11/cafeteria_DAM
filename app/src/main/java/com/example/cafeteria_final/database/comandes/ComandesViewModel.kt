package com.example.cafeteria_final.database.comandes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafeteria_final.Shared.sharedApp
import com.example.cafeteria_final.database.producte.ProducteEntity
import com.example.cafeteria_final.database.usuari.UsuariDao
import com.example.cafeteria_final.database.usuari.UsuariEntity
import kotlinx.coroutines.launch

class ComandesViewModel(val database: ComandaDao,
                        application: Application
) : AndroidViewModel(application){
    fun insert(comanda: ComandaEntity) = viewModelScope.launch {
        database.insert(comanda);
    }
    fun listar(): List<ComandaEntity> {
        val comanda = database.getAll(sharedApp.prefs.name.toString())
        return comanda
    }

    fun pasar(beguda: String, primer: String, postre: String, total:String, user:String){
        viewModelScope.launch {
            val comanda = ComandaEntity()
            comanda.beguda=beguda
            comanda.primer=primer
            comanda.postre=postre
            comanda.total=total
            comanda.user=user
            insert(comanda)
        }
    }
}