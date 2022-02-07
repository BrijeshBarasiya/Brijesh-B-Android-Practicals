package com.example.recyclevier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_recyclerview_and_adapters.demo_buttom_navigation
import kotlinx.android.synthetic.main.three_c_recyclerview_and_adapters.demo_condition_listview
import kotlinx.android.synthetic.main.three_c_recyclerview_and_adapters.demo_expandable_listview
import kotlinx.android.synthetic.main.three_c_recyclerview_and_adapters.demo_expandable_recyclerview
import kotlinx.android.synthetic.main.three_c_recyclerview_and_adapters.demo_grid_recyclerview
import kotlinx.android.synthetic.main.three_c_recyclerview_and_adapters.demo_multiple_listview
import kotlinx.android.synthetic.main.three_c_recyclerview_and_adapters.demo_playstore
import kotlinx.android.synthetic.main.three_c_recyclerview_and_adapters.demo_simple_listview

class RecyclerViewandAdapters : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_recyclerview_and_adapters)

        demo_simple_listview.setOnClickListener {
            var intent = Intent(applicationContext, SimpleList:: class.java)
            startActivity(intent)
        }
        demo_condition_listview.setOnClickListener {
            var intent = Intent(applicationContext, ConditionBasedListView:: class.java)
            startActivity(intent)
        }
        demo_multiple_listview.setOnClickListener {
            var intent = Intent(applicationContext, CustomListView:: class.java)
            startActivity(intent)
        }
        demo_expandable_listview.setOnClickListener {
            var intent = Intent(applicationContext, ExpandableListView:: class.java)
            startActivity(intent)
        }
        demo_expandable_recyclerview.setOnClickListener {
            var intent = Intent(applicationContext, ExpandableRecyclerView:: class.java)
            startActivity(intent)
        }
        demo_buttom_navigation.setOnClickListener {
            var intent = Intent(applicationContext, BottomNavigation:: class.java)
            startActivity(intent)
        }
        demo_grid_recyclerview.setOnClickListener {
            var intent = Intent(applicationContext, GridRecyclerView:: class.java)
            startActivity(intent)
        }
        demo_playstore.setOnClickListener {
            var intent = Intent(applicationContext, PlayStore:: class.java)
            startActivity(intent)
        }
    }

}