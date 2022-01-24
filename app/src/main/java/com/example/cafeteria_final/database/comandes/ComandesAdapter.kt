package com.example.cafeteria_final.database.comandes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria_final.R
import com.example.cafeteria_final.database.producte.ProducteEntity


    class ComandesAdapter (private val context: Context,
                          private val list: List<ComandaEntity>) : RecyclerView.Adapter<ComandesAdapter.ViewHolder>() {
        class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val namebeguda: TextView = view.findViewById(R.id.itemBeguda)
            val nameprimer: TextView = view.findViewById(R.id.itemPrimer)
            val namepostre: TextView = view.findViewById(R.id.itemPostre)
            val nametotal: TextView = view.findViewById(R.id.itemTotal)
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.item_comanda_recyclerview,parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.count()
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val data = list[position]
            holder.namebeguda.text = data.beguda
            holder.nameprimer.text = data.primer
            holder.namepostre.text = data.postre
            holder.nametotal.text = data.total+"€"

        }
    }
