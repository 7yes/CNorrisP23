package com.example.cnorrisp.ui.activies

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.cnorrisp.R
import com.example.cnorrisp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.frag_container) as NavHostFragment? ?: return

         // Set up Action Bar
        val navController = host.navController
        //setupBottomNavMenu(navController)
        binding.navBotMenu.setupWithNavController(navController)
    }
}
