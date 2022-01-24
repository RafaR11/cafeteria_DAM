package com.example.cafeteria_final.menu.primers

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
import com.example.cafeteria_final.databinding.FragmentPrimersBinding
import com.example.cafeteria_final.menu.begudes.BegudesFragmentDirections
import com.example.cafeteria_final.menu.begudes.PrimersAdapter
import com.example.cafeteria_final.menu.begudes.PrimersViewModel
import com.example.cafeteria_final.menu.begudes.PrimersViewModelFactory


class PrimersFragment : Fragment() {
    private lateinit var primersViewModel: PrimersViewModel
    lateinit var sharedViewModel: SharedViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPrimersBinding>(inflater,
            R.layout.fragment_primers,container,false)
        val application = requireNotNull(activity).application

        val dataSource = CafDataBase.getInstance(application).productedao

        val viewModelFactory = PrimersViewModelFactory(dataSource, application)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        primersViewModel = ViewModelProvider(
            this, viewModelFactory).get(PrimersViewModel::class.java)
        val recyclerView: RecyclerView = binding.recyclerViewPrimers
        recyclerView.layoutManager= LinearLayoutManager(this.activity)
        recyclerView.adapter= PrimersAdapter(application, primersViewModel.listar(),sharedViewModel)
        (activity as AppCompatActivity).supportActionBar?.title = "Primers"
        binding.buttonVolverPrimers.setOnClickListener{view : View ->
            view.findNavController().navigate(PrimersFragmentDirections.actionPrimersFragmentToBegudesFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = PrimersFragment()
    }
}