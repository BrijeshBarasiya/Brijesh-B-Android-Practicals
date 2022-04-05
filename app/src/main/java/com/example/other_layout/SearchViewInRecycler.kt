package com.example.other_layout

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.FourESearchViewBinding
import com.example.recyclevier.DataClass

class SearchViewInRecycler : AppCompatActivity() {

    // Variables
    private lateinit var binding: FourESearchViewBinding
    lateinit var arrayAdapter: ArrayAdapter<String>

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FourESearchViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataClass.simpleListValues)
        binding.simpleListView.adapter = arrayAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.four_f_search_menu, menu)
        val searchViewItem: MenuItem = menu.findItem(R.id.btn_search)
        val searchView = searchViewItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                arrayAdapter.filter.filter(newText)
                return false
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

}