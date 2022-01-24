package com.example.cafeteria_final.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cafeteria_final.R
import com.example.cafeteria_final.Shared.SharedViewModel
import com.example.cafeteria_final.Shared.sharedApp
import com.example.cafeteria_final.database.CafDataBase
import com.example.cafeteria_final.database.comandes.ComandesViewModel
import com.example.cafeteria_final.database.comandes.ComandesViewModelFactory
import com.example.cafeteria_final.databinding.FragmentCarritoBinding
import com.example.cafeteria_final.menu.begudes.BegudesFragmentDirections
import com.example.cafeteria_final.usuari.UsuariViewModel
import com.example.cafeteria_final.usuari.UsuariViewModelFactory
import java.lang.Exception


class CarritoFragment : Fragment() {
    lateinit var sharedViewModel: SharedViewModel
    lateinit var comandesViewmodel: ComandesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application

        val dataSource = CafDataBase.getInstance(application).comandadao
        (activity as AppCompatActivity).supportActionBar?.title = "Comanda"

        val viewModelFactory = ComandesViewModelFactory(dataSource, application)
        comandesViewmodel = ViewModelProvider(
            this, viewModelFactory).get(ComandesViewModel::class.java)
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        var binding = DataBindingUtil.inflate<FragmentCarritoBinding>(inflater,
            R.layout.fragment_carrito,container,false)
        binding.textViewBeguda.text="- "+sharedViewModel.getplat1()
        binding.textViewPrimer.text="- "+sharedViewModel.getplat2()
        binding.textViewPostre2.text="- "+sharedViewModel.getplat3()
        binding.textViewTotal.text=sharedViewModel.getpreu()+"€"
        binding.textViewCarrito.text="Aquesta es la teva comanda "+sharedApp.prefs.name+":"
        binding.buttonConfirmarCarrito2.setOnClickListener {view : View ->
            view.findNavController().navigate(CarritoFragmentDirections.actionCarritoFragmentToMenuFragment())
            try {
                comandesViewmodel.pasar(sharedViewModel.getplat1(),sharedViewModel.getplat2(),sharedViewModel.getplat3(),sharedViewModel.getpreu(),sharedApp.prefs.name.toString())
                Toast.makeText(context, "Comanda guardada correctament!", Toast.LENGTH_LONG).show()
            } catch (e: Exception){
                e.printStackTrace()
            }

        }
        binding.buttonVolverCarrito.setOnClickListener {view : View ->
            view.findNavController().navigate(CarritoFragmentDirections.actionCarritoFragmentToMenuFragment())
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = CarritoFragment()
    }
}