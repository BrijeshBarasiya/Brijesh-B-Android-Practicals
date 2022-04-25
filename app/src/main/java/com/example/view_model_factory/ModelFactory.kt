package com.example.view_model_factory

import androidx.lifecycle.ViewModel

class ModelFactory(var list: MutableList<String>): ViewModel() {

    // Function
    fun appendItem(item: String) {
        list.add(item)
    }

}