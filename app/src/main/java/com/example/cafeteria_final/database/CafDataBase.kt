package com.example.cafeteria_final.database

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.Database
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cafeteria_final.database.comandes.ComandaDao
import com.example.cafeteria_final.database.comandes.ComandaEntity
import com.example.cafeteria_final.database.producte.ProducteDao
import com.example.cafeteria_final.database.producte.ProducteEntity
import com.example.cafeteria_final.database.usuari.UsuariDao
import com.example.cafeteria_final.database.usuari.UsuariEntity
import com.google.android.datatransport.runtime.dagger.Provides
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.concurrent.Executors.newSingleThreadScheduledExecutor
import javax.inject.Singleton


@Database(entities = [ProducteEntity::class, UsuariEntity::class, ComandaEntity::class], version = 1, exportSchema = false)
abstract class CafDataBase : RoomDatabase() {
    abstract val productedao: ProducteDao
    abstract val usuaridao: UsuariDao
    abstract val comandadao: ComandaDao

    companion object {
        @Volatile
        private var INSTANCE: CafDataBase? = null
        @DelicateCoroutinesApi
        fun getInstance(context: Context): CafDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CafDataBase::class.java,
                        "CafeteriaDAM")
                        .addCallback(object: Callback(){
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                try {
                                    super.onCreate(db)
                                    Thread(Runnable { prepopulate(getInstance(context)) }).start()

                                } catch (e: Exception){
                                    e.printStackTrace()
                                }

                            }
                        })
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }

            }
        @DelicateCoroutinesApi
        private fun prepopulate(db: CafDataBase){
            GlobalScope.launch {
                val producte = ProducteEntity()

                producte.nom="Café"
                producte.categoria="Begudes"
                producte.preu="2"
                db.productedao.insert(producte)

                producte.nom="Té"
                producte.categoria="Begudes"
                producte.preu="2"
                db.productedao.insert(producte)

                producte.nom="Aigua"
                producte.categoria="Begudes"
                producte.preu="1"
                db.productedao.insert(producte)

                producte.nom="Coca-Cola"
                producte.categoria="Begudes"
                producte.preu="2"
                db.productedao.insert(producte)

                producte.nom="Aquarius"
                producte.categoria="Begudes"
                producte.preu="2"
                db.productedao.insert(producte)

                producte.nom="Ensalada mixta"
                producte.categoria="Primers"
                producte.preu="4"
                db.productedao.insert(producte)

                producte.nom="Pollastre a la planxa"
                producte.categoria="Primers"
                producte.preu="5"
                db.productedao.insert(producte)

                producte.nom="Hamburguesa completa"
                producte.categoria="Primers"
                producte.preu="5"
                db.productedao.insert(producte)

                producte.nom="Pizza"
                producte.categoria="Primers"
                producte.preu="7"
                db.productedao.insert(producte)

                producte.nom="Hamburguesa vegana"
                producte.categoria="Primers"
                producte.preu="6"
                db.productedao.insert(producte)

                producte.nom="Gelat de vainilla"
                producte.categoria="Postres"
                producte.preu="2"
                db.productedao.insert(producte)

                producte.nom="Tarta de xocolata"
                producte.categoria="Postres"
                producte.preu="4"
                db.productedao.insert(producte)

                producte.nom="Pastís de Maduixa"
                producte.categoria="Postres"
                producte.preu="3"
                db.productedao.insert(producte)

                producte.nom="Pastís de llimona"
                producte.categoria="Postres"
                producte.preu="3"
                db.productedao.insert(producte)

                producte.nom="Cupcake de Xocolata"
                producte.categoria="Postres"
                producte.preu="2"
                db.productedao.insert(producte)
            }

        }


        }

        }




