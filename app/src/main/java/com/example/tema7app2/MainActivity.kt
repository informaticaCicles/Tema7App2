package com.example.tema7app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tema7app2.databinding.ActivityMainBinding
import com.example.tema7app2.fragments.DashboardFragment
import com.example.tema7app2.fragments.HomeFragment
import com.example.tema7app2.fragments.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Inicializamos con el HomeFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, HomeFragment())
            .commit()

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {
                R.id.navigation_home -> {
                    // Acción al seleccionar Home
                    replaceFragment(HomeFragment())
                }
                R.id.navigation_dashboard -> {
                    // Acción al seleccionar Dashboard
                    replaceFragment(DashboardFragment())
                }
                R.id.navigation_notifications -> {
                    // Acción al seleccionar Notifications
                    replaceFragment(NotificationsFragment())
                }
            }
            false
        }



    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

}