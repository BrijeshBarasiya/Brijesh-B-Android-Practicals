package com.example.fragment_datapassing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.basicofkotlin.databinding.OtherDataPassingFromBinding

class DataPassingFrom : Fragment() {

    // VARIABLES
    private lateinit var binding: OtherDataPassingFromBinding
    // DataPassingFromArgs IS OBJECT OF FRAGMENT ARGUMENTS
    private val args: DataPassingFromArgs by navArgs()

    // OVERRIDE FUNCTION
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OtherDataPassingFromBinding.inflate(inflater)
        binding.lblAnswer.text = args.argument1
        return binding.root
    }

}