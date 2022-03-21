package com.example.fragment_datapassing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.basicofkotlin.databinding.OtherDataPassingToBinding

class DataPassingTo : Fragment() {

    // VARIABLES
    private lateinit var binding: OtherDataPassingToBinding

    // OVERRIDE FUNCTIONS
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OtherDataPassingToBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            // DataPassingToDirections IS OBJECT OF NAV GRAPH FRAGMENT ACTIONS
            // actionDataPassingToToDataPassingFrom IS ID OF NAV GRAPH ACTION
            // setArgument1 IS TO SET THAT ARGUMENT VALUE
            val action =  DataPassingToDirections.redirectToParameter("HELLO GOOD MORNING!!")
            view.findNavController().navigate(action)
        }
    }

}