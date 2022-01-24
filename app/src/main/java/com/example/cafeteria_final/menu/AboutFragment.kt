package com.example.cafeteria_final.menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cafeteria_final.R
import com.example.cafeteria_final.Shared.sharedApp
import com.example.cafeteria_final.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater,
            R.layout.fragment_about,container,false)
        (activity as AppCompatActivity).supportActionBar?.title = "Informació"
        binding.buttonVolverInfo.setOnClickListener{view : View ->
            if (sharedApp.prefs.name!=""){
                view.findNavController().navigate(AboutFragmentDirections.actionAboutFragmentToMenuFragment())
            } else {
                view.findNavController().navigate(AboutFragmentDirections.actionAboutFragmentToIniciFragment())
            }
        }
        binding.textViewTelf.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:"+binding.textViewTelf.text.toString()))
            startActivity(intent)

        }
        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setType("message/rfc822")
            intent.setData(Uri.parse("mailto:"+binding.textViewEmail))
            startActivity(intent)
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    companion object {
        @JvmStatic
        fun newInstance() = AboutFragment()
    }
}