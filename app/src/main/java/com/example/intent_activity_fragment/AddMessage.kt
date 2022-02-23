package com.example.intent_activity_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.basicofkotlin.databinding.ThreeDFragmentAddMessageBinding

class AddMessage: Fragment() {

    private lateinit var binding: ThreeDFragmentAddMessageBinding
    private val viewModelClass: ViewModelClass by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModelClass.fragment = AddMessage()
        binding = ThreeDFragmentAddMessageBinding.inflate(inflater)
        binding.viewModel = viewModelClass
        return binding.root
    }

}