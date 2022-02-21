package com.example.recyclevier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_grid_recycler_view.grid_recyclerview

class GridRecyclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_grid_recycler_view)
        val adapter = GridRecyclerViewAdapter(GridRecyclerView::class, 0)
        grid_recyclerview.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        grid_recyclerview.adapter = adapter
    }

}