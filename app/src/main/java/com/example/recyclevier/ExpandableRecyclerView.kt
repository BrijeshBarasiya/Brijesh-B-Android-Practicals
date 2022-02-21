package com.example.recyclevier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_expandable_recycler_view.expandable_recyclerview


class ExpandableRecyclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_expandable_recycler_view)
        val adapter = ExpandableRecyclerViewAdapter(DataClass.expandableRecyclerViewValues)
        expandable_recyclerview.adapter = adapter
    }

}