package com.example.cafeteria_final

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.cafeteria_final.Shared.SharedViewModel
import com.example.cafeteria_final.Shared.sharedApp
import com.example.cafeteria_final.database.comandes.HistorialFragment
import com.example.cafeteria_final.menu.AboutFragment
import com.example.cafeteria_final.menu.MenuFragment
import com.example.cafeteria_final.usuari.IniciFragment
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = this.findNavController(R.id.myNavHostFragment)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        NavigationUI.setupWithNavController(navView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        navView.setItemIconTintList(null);

        navController.addOnDestinationChangedListener {_, destination, _ ->
            if (destination.id==R.id.iniciFragment){
                sharedApp.prefs.name = ""
            }
            if (destination.id==R.id.menuFragment||destination.id==R.id.HistorialFragment||destination.id==R.id.aboutFragment){
                supportActionBar?.setDisplayHomeAsUpEnabled(false)

            }
            if (sharedApp.prefs.name=="") {
                navView.menu.findItem(R.id.HistorialFragment).setVisible(false)
                navView.menu.findItem(R.id.menuFragment).setVisible(false)

            } else {
                navView.menu.findItem(R.id.HistorialFragment).setVisible(true)
                navView.menu.findItem(R.id.menuFragment).setVisible(true)
            }
        }



    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

}