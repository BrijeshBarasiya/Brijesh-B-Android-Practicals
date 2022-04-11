package com.example.view_model_factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.intent_activity_fragment.FailedMessage

class ViewModelFactory(var list: MutableList<String>): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ModelFactory::class.java)) {
            return ModelFactory(list) as T
        }
        throw  IllegalArgumentException(FailedMessage)
    }

}