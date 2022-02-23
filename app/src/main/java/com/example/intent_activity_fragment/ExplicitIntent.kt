package com.example.intent_activity_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.databinding.ThreeDExplicitIntentBinding


class ExplicitIntent : AppCompatActivity() {

    private lateinit var binding: ThreeDExplicitIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ThreeDExplicitIntentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.explicitTitle.text = intent.getStringExtra(ConstantValue.ExplicitIntentDataKeys.nameValue)
        val image = intent.extras?.getInt(ConstantValue.ExplicitIntentDataKeys.imageValue)
        if (image != null)
            binding.explicitImage.setImageResource(image)
    }

}