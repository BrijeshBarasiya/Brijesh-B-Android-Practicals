package com.example.architecture.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecture.mvvm.model.MVVMModelClass

class MVVMViewModel: ViewModel() {

    private val mvvmModelClass = MVVMModelClass()
    var arithmeticParameter1 = MutableLiveData("0")
    var arithmeticParameter2 = MutableLiveData("0")

    fun arithmeticOperation(operation: String): Boolean {
        return if(mvvmModelClass.isParameterTwoEmpty(arithmeticParameter2.value.toString())) {
            when (operation) {
                "ADD" -> addition()
                "SUB" -> subtraction()
                "MUL" -> multiplication()
                "DIV" -> division()
            }
            true
        } else {
            false
        }
    }

    private fun addition() {
        arithmeticParameter1.value = ((arithmeticParameter1.value?.toFloat() ?: 0F) + (arithmeticParameter2.value?.toFloat() ?: 0F)).toString()
    }

    private fun subtraction() {
        arithmeticParameter1.value = ((arithmeticParameter1.value?.toFloat() ?: 0F) - (arithmeticParameter2.value?.toFloat() ?: 0F)).toString()
    }

    private fun multiplication() {
        arithmeticParameter1.value = ((arithmeticParameter1.value?.toFloat() ?: 0F) * (arithmeticParameter2.value?.toFloat() ?: 0F)).toString()
    }

    private fun division() {
        arithmeticParameter1.value = ((arithmeticParameter1.value?.toFloat() ?: 0F) / (arithmeticParameter2.value?.toFloat() ?: 0F)).toString()
    }

}
