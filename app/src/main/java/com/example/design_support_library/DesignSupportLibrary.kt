package com.example.design_support_library

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.SevenDesignSupportLibraryBinding

class DesignSupportLibrary : AppCompatActivity(), View.OnClickListener {

    // VARIABLES
    private lateinit var binding: SevenDesignSupportLibraryBinding

    // OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SevenDesignSupportLibraryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.onClicked = this
    }

    override fun onClick(view: View) {
        when(view.id) {
            binding.btnNavigationView.id -> {
                Intent(this, NavigationView::class.java).apply {
                    startActivity(this)
                }
            }
            binding.btnToolbar.id -> {
                Intent(this, Toolbar::class.java).apply {
                    startActivity(this)
                }
            }
            binding.btnCoordinatorLayout.id -> {
                Intent(this, CoordinatorLayout::class.java).apply {
                    startActivity(this)
                }
            }
            binding.btnTabBar.id -> {
                Intent(this, TabBar::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }

}