package com.example.expenses.expenses.tracking.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.ui.fragment.HomeFragment
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

private const val HOME_TAG = "Home"


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setFragment(HomeFragment(), HOME_TAG)
        setUpBottomNavigation()

    }

    private fun setUpBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            onNavigationItemSelected(it)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home_fragment -> {
                supportFragmentManager.beginTransaction()
                setFragment(HomeFragment(), HOME_TAG)
                true
            }
            else -> {
                Toast.makeText(applicationContext, "Nothing", Toast.LENGTH_LONG).show()
                false
            }
        }
    }

    private fun setFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_holder, fragment, tag).commit()
    }
}