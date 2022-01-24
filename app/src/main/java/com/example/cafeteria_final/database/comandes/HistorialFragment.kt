package com.example.cafeteria_final.database.comandes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria_final.R
import com.example.cafeteria_final.database.CafDataBase
import com.example.cafeteria_final.databinding.FragmentHistorialBinding
import com.example.cafeteria_final.menu.begudes.BegudesAdapter
import com.example.cafeteria_final.menu.begudes.BegudesFragmentDirections
import com.example.cafeteria_final.menu.begudes.BegudesViewModel
import com.example.cafeteria_final.menu.begudes.BegudesViewModelFactory
import com.google.android.material.navigation.NavigationView


class HistorialFragment : Fragment() {
    private lateinit var comandesViewModel: ComandesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentHistorialBinding>(inflater,
            com.example.cafeteria_final.R.layout.fragment_historial,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Historial de comandes"
        val application = requireNotNull(activity).application

        val dataSource = CafDataBase.getInstance(application).comandadao

        val viewModelFactory = ComandesViewModelFactory(dataSource, application)

        comandesViewModel = ViewModelProvider(
            this, viewModelFactory).get(ComandesViewModel::class.java)
        val recyclerView: RecyclerView = binding.recyclerViewComandes
        recyclerView.layoutManager= LinearLayoutManager(this.activity)
        recyclerView.adapter= ComandesAdapter(application, comandesViewModel.listar())
        (activity as AppCompatActivity).supportActionBar?.title = "Comandes"


        binding.buttonVolverHistorial.setOnClickListener{view : View ->
            view.findNavController().navigate(HistorialFragmentDirections.actionHistorialFragmentToMenuFragment())
        }

        setHasOptionsMenu(true)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = HistorialFragment()
    }
}