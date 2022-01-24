package com.example.cafeteria_final.usuari

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cafeteria_final.R
import com.example.cafeteria_final.database.CafDataBase
import com.example.cafeteria_final.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var provaViewmodel: UsuariViewModel
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Registrarse"
        val application = requireNotNull(activity).application

        val dataSource = CafDataBase.getInstance(application).usuaridao

        val viewModelFactory = UsuariViewModelFactory(dataSource, application)

        provaViewmodel = ViewModelProvider(
            this, viewModelFactory).get(UsuariViewModel::class.java)
        binding.roomViewmodel = provaViewmodel
        binding.lifecycleOwner = this
        binding.buttonRegistrar.setOnClickListener{view : View ->
            view.findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToIniciFragment())
            val nom = binding.editTextNom.text.toString();
            val cognom = binding.editTextTextApellidos.text.toString();
            val correu = binding.editTextTextEmail2.text.toString();
            val contrasenya = binding.editTextPassR.text.toString();
            val usuari = binding.editTextUsuari.text.toString();
            if (!(nom.isEmpty()&&cognom.isEmpty()&&correu.isEmpty()&&contrasenya.isEmpty())){
                provaViewmodel.pasar(nom, cognom, correu,usuari, contrasenya)
                Toast.makeText(context, "Usuari guardat correctament!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Els camps no poden ser buits!", Toast.LENGTH_LONG).show()
            }
        }
        binding.buttonVolver.setOnClickListener{view : View ->
            view.findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToIniciFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = RegisterFragment()
    }
}