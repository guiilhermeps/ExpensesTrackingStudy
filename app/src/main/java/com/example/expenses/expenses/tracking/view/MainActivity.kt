package com.example.expenses.expenses.tracking.view

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.databinding.ActivityMainBinding
import com.example.expenses.expenses.tracking.fragment.HomeFragment
import com.example.expenses.expenses.tracking.fragment.ReportFragment
import com.google.android.material.navigation.NavigationView

private const val HOME_TAG = "Home"
private const val REPORT_TAG = "Report"
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        with(getSharedPreferences("themeInfo", Context.MODE_PRIVATE)) {
            setTheme(getInt("InfoThemeInCache", R.style.ExpensesTrackingLight))
        }
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
            else -> false
        }
    }

    private fun setFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.main_view_fragment_holder,
                fragment,
                tag
            ).commit()
    }
}