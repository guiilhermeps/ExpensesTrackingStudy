package com.example.expenses.expenses.tracking

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainLinearActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_main)

        bottomNavigation = findViewById(R.id.bottom_navigation)

        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            onNavigationItemSelected(it)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.linear_layout -> {
                Toast.makeText(applicationContext, "Linear", Toast.LENGTH_LONG).show()
                true
            }
            R.id.relative_layout -> {
                Toast.makeText(applicationContext, "Relative", Toast.LENGTH_LONG).show()
                true
            }
            else -> {
                Toast.makeText(applicationContext, "Nothing", Toast.LENGTH_LONG).show()
                false
            }
        }
    }
}