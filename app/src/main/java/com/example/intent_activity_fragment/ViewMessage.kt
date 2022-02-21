package com.example.intent_activity_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.basicofkotlin.databinding.ThreeDFragmentViewMessageBinding

class ViewMessage: Fragment() {

    private lateinit var binding: ThreeDFragmentViewMessageBinding
    private val viewModelClass: ViewModelClass by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModelClass.fragment = ViewMessage()
        binding = ThreeDFragmentViewMessageBinding.inflate(inflater)
        binding.viewModel = viewModelClass
        binding.lifecycleOwner = this
        return binding.root
    }

}