package com.example.cafeteria_final.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.cafeteria_final.R
import com.example.cafeteria_final.Shared.SharedViewModel
import com.example.cafeteria_final.Shared.sharedApp
import com.example.cafeteria_final.databinding.FragmentMenuBinding
import com.google.android.material.navigation.NavigationView

class MenuFragment : Fragment() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater,
            R.layout.fragment_menu,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Inici"
        binding.textBenvingut.text = "¡Benvingut ${sharedApp.prefs.name}!"
        binding.imageButtonEscollirMenu.setOnClickListener{view : View ->
            view.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToBegudesFragment())
        }
        binding.imageButtonHistorial.setOnClickListener{view : View ->
            view.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToHistorialFragment())
        }
        binding.imageButtonInfo.setOnClickListener{view : View ->
            view.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToAboutFragment())
        }
        binding.buttonLogout.setOnClickListener{view : View ->
            sharedApp.prefs.name = ""
            view.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToIniciFragment())
        }
        setHasOptionsMenu(true)
        return binding.root

    }



    companion object {
        @JvmStatic
        fun newInstance() = MenuFragment()
    }
}