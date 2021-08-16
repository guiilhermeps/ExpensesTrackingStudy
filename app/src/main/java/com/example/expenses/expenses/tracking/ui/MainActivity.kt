package com.example.expenses.expenses.tracking.ui

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.ui.fragment.HomeFragment
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.databinding.ActivityMainBinding
import com.example.expenses.expenses.tracking.ui.fragment.ReportFragment
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO_CACHE
import com.google.android.material.navigation.NavigationView

private const val HOME_TAG = "Home"
private const val REPORT_TAG = "Report"

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setTheme()
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
                setFragment(HomeFragment(), HOME_TAG)
                true
            }
            R.id.report_fragment -> {
                setFragment(ReportFragment(), REPORT_TAG)
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

    private fun setTheme() {
        with(getSharedPreferences(THEME_INFO, Context.MODE_PRIVATE)) {
            setTheme(getInt(THEME_INFO_CACHE, R.style.ExpensesTrackingLight))
        }
    }
}