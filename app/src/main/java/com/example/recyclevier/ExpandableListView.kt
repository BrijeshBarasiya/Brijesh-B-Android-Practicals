package com.example.recyclevier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_expandable_list_view.expandable_listview

class ExpandableListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_expandable_list_view)
        val expandedAdapter = ExapandableListAdapter(DataClass.expandableListViewValues)
        expandable_listview.setAdapter(expandedAdapter)
    }

}