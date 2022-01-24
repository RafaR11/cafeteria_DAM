package com.example.cafeteria_final.database.producte

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productes")
data class ProducteEntity(
    @NonNull @PrimaryKey @ColumnInfo(name = "Nom") var nom: String="",
    @ColumnInfo(name = "Preu") var preu: String="",
    @ColumnInfo(name = "Categoria") var categoria: String=""

    )