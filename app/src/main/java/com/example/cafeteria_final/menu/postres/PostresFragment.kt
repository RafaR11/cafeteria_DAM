package com.example.cafeteria_final.menu.postres

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cafeteria_final.R
import com.example.cafeteria_final.Shared.SharedViewModel
import com.example.cafeteria_final.database.CafDataBase
import com.example.cafeteria_final.databinding.FragmentPostresBinding
import com.example.cafeteria_final.databinding.FragmentPrimersBinding
import com.example.cafeteria_final.menu.begudes.PrimersAdapter
import com.example.cafeteria_final.menu.begudes.PrimersViewModel
import com.example.cafeteria_final.menu.begudes.PrimersViewModelFactory

class PostresFragment : Fragment() {
    private lateinit var postresViewModel: PostresViewModel
    lateinit var sharedViewModel: SharedViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPostresBinding>(inflater,
            R.layout.fragment_postres,container,false)
        val application = requireNotNull(activity).application

        val dataSource = CafDataBase.getInstance(application).productedao

        val viewModelFactory = PostresViewModelFactory(dataSource, application)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        postresViewModel = ViewModelProvider(
            this, viewModelFactory).get(PostresViewModel::class.java)
        val recyclerView: RecyclerView = binding.recyclerViewPostres
        recyclerView.layoutManager= LinearLayoutManager(this.activity)
        recyclerView.adapter= PostresAdapter(application, postresViewModel.listar(),sharedViewModel)
        (activity as AppCompatActivity).supportActionBar?.title = "Postres"
        binding.buttonVolverPostres.setOnClickListener{view : View ->
            view.findNavController().navigate(PostresFragmentDirections.actionPostresFragmentToPrimersFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = PostresFragment()
    }
}