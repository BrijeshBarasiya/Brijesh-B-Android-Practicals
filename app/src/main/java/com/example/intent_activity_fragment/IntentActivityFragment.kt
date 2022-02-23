package com.example.intent_activity_fragment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.ThreeDIntentActivityFragmentBinding


class IntentActivityFragment : AppCompatActivity() {

    private lateinit var binding: ThreeDIntentActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThreeDIntentActivityFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.demoIntent.setOnClickListener {
            val intent = Intent(applicationContext, IntentClass:: class.java)
            startActivity(intent)
        }
        binding.demoLifeCycle.setOnClickListener {
            val intent = Intent(applicationContext, ActivityLifeCycle:: class.java)
            startActivity(intent)
        }
        binding.practicalOne.setOnClickListener {
            val intent = Intent(applicationContext, Practical1:: class.java)
            startActivity(intent)
        }
        binding.practicalTwo.setOnClickListener {
            val intent = Intent(applicationContext, Practical2:: class.java)
            startActivity(intent)
        }
    }

}