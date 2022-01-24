package com.example.cafeteria_final.menu.begudes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria_final.R
import com.example.cafeteria_final.Shared.SharedViewModel
import com.example.cafeteria_final.database.producte.ProducteEntity

class BegudesAdapter (private val context: Context,
                      private val list: List<ProducteEntity>,
                      private val shared: SharedViewModel
) : RecyclerView.Adapter<BegudesAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameview: TextView = view.findViewById(R.id.itemNom)
        val preuview: TextView = view.findViewById(R.id.itemPreu)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.nameview.text = data.nom
        holder.preuview.text = data.preu.toString()+"€"
        holder.itemView.setOnClickListener{
            view: View ->
            view.findNavController().navigate(R.id.action_begudesFragment_to_primersFragment)
            shared.setplat1(data.nom)
            shared.setpreu(data.preu)
        }
    }
}