package com.example.other_layout

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.FourEFourExerciseBinding

class FourExercise : AppCompatActivity() {

    // Variables
    private lateinit var binding: FourEFourExerciseBinding

    // Override Function
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FourEFourExerciseBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun onTopicClicked(view: View) {
        when(view.id) {
            binding.txtNestedScroll.id -> {
                Intent(this, NestedLayout::class.java).apply {
                    startActivity(this)
                }
            }
            binding.txtSearchView.id -> {
                Intent(this, SearchViewInRecycler::class.java).apply {
                    startActivity(this)
                }
            }
            binding.txtWebView.id -> {
                Intent(this, WebView::class.java).apply {
                    startActivity(this)
                }
            }
        }
    }

}