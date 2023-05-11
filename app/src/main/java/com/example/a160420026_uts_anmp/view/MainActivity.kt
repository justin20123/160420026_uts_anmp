package com.example.a160420026_uts_anmp.view

import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.example.a160420026_uts_anmp.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawerLayout)
        navController = (supportFragmentManager.findFragmentById(R.id.fragmentHost)
                as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navView)
        NavigationUI.setupWithNavController(navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout)
                || super.onSupportNavigateUp()
    }



}