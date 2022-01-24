package com.example.cafeteria_final.database.usuari

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuaris")
data class UsuariEntity(
    @ColumnInfo(name = "Nom") var nom: String="",
    @ColumnInfo(name = "Cognoms") var cognoms: String="",
    @PrimaryKey @ColumnInfo(name = "Correu") var correu: String="",
    @ColumnInfo(name = "Usuari") var usuari: String="",
    @ColumnInfo(name = "Contrasenya") var contrasenya: String=""

    )