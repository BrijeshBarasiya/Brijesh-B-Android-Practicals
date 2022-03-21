package com.example.design_support_library

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.SevenNavigationViewBinding

class NavigationView : AppCompatActivity() {

    // VARIABLES
    private lateinit var binding: SevenNavigationViewBinding
    private lateinit var nav: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    // OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SevenNavigationViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        nav = Navigation.findNavController(this, R.id.jetpack_fragment)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_gallary, R.id.nav_add_message, R.id.nav_view_message), binding.layoutDrawer)
        NavigationUI.setupActionBarWithNavController(this, nav, appBarConfiguration)
        binding.menuNavigationView.setupWithNavController(nav)
        val menuProfile = binding.menuNavigationView.inflateHeaderView(R.layout.seven_menu_profile)
        val menuName = menuProfile.findViewById<TextView>(R.id.lbl_user_name)
        menuName.text = this.getString(R.string.app_name)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(nav, appBarConfiguration)
    }

    override fun onBackPressed() {
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START))
            binding.layoutDrawer.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

}