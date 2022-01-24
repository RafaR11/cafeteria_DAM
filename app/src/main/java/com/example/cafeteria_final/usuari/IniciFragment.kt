package com.example.cafeteria_final.usuari

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.cafeteria_final.R
import com.example.cafeteria_final.Shared.SharedViewModel
import com.example.cafeteria_final.Shared.prefs
import com.example.cafeteria_final.Shared.sharedApp
import com.example.cafeteria_final.database.CafDataBase
import com.example.cafeteria_final.database.producte.ProducteViewModel
import com.example.cafeteria_final.database.producte.ProducteViewModelFactory

class IniciFragment : Fragment() {
    private lateinit var provaViewmodel: UsuariViewModel
    private lateinit var producteViewModel: ProducteViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<com.example.cafeteria_final.databinding.FragmentIniciBinding>(inflater,
            R.layout.fragment_inici,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Cafeteria DAM"
        val application = requireNotNull(activity).application
        val dataSource = CafDataBase.getInstance(application).usuaridao
        val dataSourceP = CafDataBase.getInstance(application).productedao
        val viewModelFactory = UsuariViewModelFactory(dataSource, application)
        val viewModelFactoryP = ProducteViewModelFactory(dataSourceP, application)
        producteViewModel = ViewModelProvider(
            this, viewModelFactoryP).get(ProducteViewModel::class.java)
        provaViewmodel = ViewModelProvider(
            this, viewModelFactory).get(UsuariViewModel::class.java)
        binding.roomViewmodel = provaViewmodel
        binding.productViewmodel = producteViewModel
        binding.lifecycleOwner = this



        binding.buttonEntrar.setOnClickListener { view: View ->
            var user = binding.editTextTextEmail.text.toString()
            val pass = binding.editTextTextPassword.text.toString()
            if (user.isEmpty()||pass.isEmpty()){
                Toast.makeText(context, "Els camps no poden ser buits!", Toast.LENGTH_LONG).show()
            } else {
                val a = provaViewmodel.login(user, pass)
                if (a == true) {
                    sharedApp.prefs.name = binding.editTextTextEmail.text.toString()
                    var user = binding.editTextTextEmail
                    var pass = binding.editTextTextPassword
                    if (sharedApp.prefs.name!=""){
                        user.setText("")
                        pass.setText("")
                    }
                    view.findNavController()
                        .navigate(IniciFragmentDirections.actionIniciFragmentToMenuFragment())

                } else {
                    Toast.makeText(context, "Credencials no valides!", Toast.LENGTH_LONG).show()

                }
            }
            }

        binding.buttonRegistrarse.setOnClickListener{view : View ->
            view.findNavController().navigate(IniciFragmentDirections.actionIniciFragmentToRegisterFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = IniciFragment()
    }
}