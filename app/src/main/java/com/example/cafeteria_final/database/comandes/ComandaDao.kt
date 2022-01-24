package com.example.cafeteria_final.database.comandes

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.cafeteria_final.database.usuari.UsuariEntity
@Dao
interface ComandaDao {
    @Insert
    fun insert(comanda: ComandaEntity)

    @Query("SELECT * from comandes WHERE usuari LIKE :user ")
    fun getAll(user: String): List<ComandaEntity>;
}