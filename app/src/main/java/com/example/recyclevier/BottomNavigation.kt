package com.example.recyclevier

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.basicofkotlin.R
import com.example.uiwidgets.FirstFragment
import com.example.uiwidgets.SecondFragment
import kotlinx.android.synthetic.main.three_c_buttom_navigation.buttom_navigation
import kotlinx.android.synthetic.main.three_c_buttom_navigation.view_pager

class BottomNavigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_buttom_navigation)
        val viewAdapter = PageAdapter(supportFragmentManager)
        view_pager.adapter = viewAdapter
        buttom_navigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> view_pager.currentItem = 0
                R.id.nav_call -> view_pager.currentItem = 1
                R.id.nav_profile -> view_pager.currentItem = 0
                R.id.nav_setting -> view_pager.currentItem = 1
            }
            true
        }
    }

}

class PageAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 2
    }
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> return FirstFragment()
            1 -> return SecondFragment()
            else -> FirstFragment()
        }
    }

}