package com.example.cafeteria_final.database.producte

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cafeteria_final.database.usuari.UsuariEntity

@Dao
interface ProducteDao {

    @Query("SELECT * from productes WHERE categoria = 'Begudes'")
    fun getBegudes(): List<ProducteEntity>;

    @Query("SELECT * from productes WHERE categoria = 'Primers'")
    fun getPrimers(): List<ProducteEntity>;

    @Query("SELECT * from productes WHERE categoria = 'Postres'")
    fun getPostres(): List<ProducteEntity>;

    @Insert
    fun insert(producte: ProducteEntity)

}