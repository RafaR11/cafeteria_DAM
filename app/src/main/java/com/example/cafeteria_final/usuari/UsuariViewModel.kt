package com.example.cafeteria_final.usuari

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cafeteria_final.database.usuari.UsuariDao
import com.example.cafeteria_final.database.usuari.UsuariEntity
import kotlinx.coroutines.launch

class UsuariViewModel(val database: UsuariDao,
                      application: Application
) : AndroidViewModel(application){
        fun insert(person: UsuariEntity) = viewModelScope.launch {
            database.insert(person);
        }
        fun login(user: String, contrasenya: String): Boolean {
            if (contrasenya==database.getpass(user)){
                return true
            } else {
                return false
            }
        }

        fun pasar(nom: String, cognom: String, correu: String,usuari: String,contrasenya: String){
            viewModelScope.launch {
                val persona = UsuariEntity()
                persona.nom= nom
                persona.cognoms=cognom
                persona.correu=correu
                persona.usuari=usuari
                persona.contrasenya=contrasenya
                insert(persona)
            }
        }
    }
