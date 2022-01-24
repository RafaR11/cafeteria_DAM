package com.example.cafeteria_final.menu.begudes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cafeteria_final.R
import com.example.cafeteria_final.databinding.FragmentBegudesBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria_final.Shared.SharedViewModel
import com.example.cafeteria_final.database.CafDataBase


class BegudesFragment : Fragment() {
    lateinit var sharedViewModel: SharedViewModel
    lateinit var begudesViewModel: BegudesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBegudesBinding>(inflater,
            R.layout.fragment_begudes,container,false)
        val application = requireNotNull(activity).application

        val dataSource = CafDataBase.getInstance(application).productedao

        val viewModelFactory = BegudesViewModelFactory(dataSource, application)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        begudesViewModel = ViewModelProvider(
            this, viewModelFactory).get(BegudesViewModel::class.java)
        val recyclerView: RecyclerView = binding.recyclerViewBegudes
        recyclerView.layoutManager= LinearLayoutManager(this.activity)
        recyclerView.adapter=BegudesAdapter(application, begudesViewModel.listar(),sharedViewModel)
        (activity as AppCompatActivity).supportActionBar?.title = "Begudes"
        binding.buttonVolverBebidas.setOnClickListener{view : View ->
            view.findNavController().navigate(BegudesFragmentDirections.actionBegudesFragmentToMenuFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = BegudesFragment()
    }
}