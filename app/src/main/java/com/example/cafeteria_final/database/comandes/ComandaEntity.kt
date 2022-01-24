package com.example.cafeteria_final.database.comandes

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comandes")
data class ComandaEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id: Int=0,
    @NonNull @ColumnInfo(name = "Beguda") var beguda: String="",
    @ColumnInfo(name = "Primer")var primer: String="",
    @ColumnInfo(name = "Postre")var postre: String="",
    @ColumnInfo(name = "Total")var total: String="",
    @ColumnInfo(name = "Usuari")var user: String=""

)