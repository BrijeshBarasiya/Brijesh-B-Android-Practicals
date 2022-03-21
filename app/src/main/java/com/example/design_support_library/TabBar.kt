package com.example.design_support_library

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.basicofkotlin.databinding.SevenTabBarBinding
import com.example.intent_activity_fragment.AddMessage
import com.example.intent_activity_fragment.Gallery
import com.example.intent_activity_fragment.ViewMessage
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabBar : AppCompatActivity() {

    // VARIABLES
    private lateinit var binding: SevenTabBarBinding

    // OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SevenTabBarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val tabBar = binding.tabLayout
        tabBar.tabGravity = TabLayout.GRAVITY_FILL
        val viewPager = binding.viewPagerTwo
        viewPager.adapter = ViewPagerTwoAdapter(this)
        TabLayoutMediator(tabBar, viewPager) {tab, position ->
            val tabNames = listOf("Gallery", "Add Message", "View Message")
            tab.text = tabNames[position]
        }.attach()
        setSupportActionBar(binding.screenSmallToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.screenSmallToolbar.setNavigationOnClickListener {
            finish()
        }
    }

}

class ViewPagerTwoAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> Gallery()
            1 -> AddMessage()
            2 -> ViewMessage()
            else -> Gallery()
        }
    }

}

