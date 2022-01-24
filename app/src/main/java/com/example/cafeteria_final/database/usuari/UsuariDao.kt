package com.example.cafeteria_final.database.usuari

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UsuariDao {

    @Insert
    fun insert(person: UsuariEntity)

    @Update
    fun update(person: UsuariEntity)

    @Query("SELECT Contrasenya from usuaris WHERE Usuari LIKE :user")
    fun getpass(user: String): String

    @Query("DELETE FROM usuaris")
    fun clear()

    @Query("SELECT * from usuaris")
    fun getAll(): List<UsuariEntity>;

}