package com.example.intent_activity_fragment

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.ThreeDPractical1Binding

class Practical1 : AppCompatActivity() {

    private val viewModelClass: ViewModelClass by viewModels()
    private lateinit var binding: ThreeDPractical1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThreeDPractical1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setFragment()
        binding.prctBottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_gallary -> viewModelClass.fragment = Gallery()
                R.id.nav_add_message -> viewModelClass.fragment = AddMessage()
                R.id.nav_view_message -> viewModelClass.fragment = ViewMessage()
            }
            setFragment()
            true
        }
    }
    fun setFragment() {
        var fragmentManager: FragmentTransaction = supportFragmentManager.beginTransaction().replace(R.id.prct_view_pager, viewModelClass.fragment)
        fragmentManager.commit()
    }

}
