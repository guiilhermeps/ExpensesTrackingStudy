package com.example.expenses.expenses.tracking

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.expenses.expenses.tracking.databinding.ActivityMainBinding
import com.example.expenses.expenses.tracking.databinding.ActivityMainConstraintBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            onNavigationItemSelected(it)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.linear_layout -> {
                Toast.makeText(applicationContext, "Linear", Toast.LENGTH_LONG).show()
                true
            }
            R.id.relative_layout -> {
                Toast.makeText(applicationContext, "Relative", Toast.LENGTH_LONG).show()
                true
            }
            R.id.constraint_layout -> {
                Toast.makeText(applicationContext, "Constraint", Toast.LENGTH_LONG).show()
                true
            }
            else -> {
                Toast.makeText(applicationContext, "Nothing", Toast.LENGTH_LONG).show()
                false
            }
        }
    }
}