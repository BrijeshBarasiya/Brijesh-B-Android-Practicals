package com.example.design_support_library

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.SevenToolbaarBinding

class Toolbar : AppCompatActivity() {

    // VARIABLES
    private lateinit var binding: SevenToolbaarBinding

    // OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SevenToolbaarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.seven_navigation_view, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (R.id.nav_communicate != item.itemId)
            binding.lblResult.text = item.title
        return true
    }

}