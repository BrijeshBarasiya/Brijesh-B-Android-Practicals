package com.example.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicofkotlin.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.tab_layout_demo.tbly_demo
import kotlinx.android.synthetic.main.tab_layout_demo.tbly_view_pager

class TabLayoutDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tab_layout_demo)

        tbly_demo.addTab(tbly_demo.newTab().setText("Tab1"))
        tbly_demo.addTab(tbly_demo.newTab().setText("Tab2"))
        tbly_demo.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = FragmentAdapter(tbly_demo.tabCount, supportFragmentManager, lifecycle)
        tbly_view_pager.adapter = adapter
        tbly_demo.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tbly_view_pager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

}