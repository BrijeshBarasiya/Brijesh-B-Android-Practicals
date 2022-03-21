package com.example.architecture.mvp.presenter

import com.example.architecture.mvp.model.MVPModel

class MVPPresenterClass: IMVPPresenterClass {

    private lateinit var mvpModel: MVPModel

    override fun setValue(values: MVPModel) {
        this.mvpModel = values
    }

    override fun addition()  {
        mvpModel.arithmeticParameter1.value = ((mvpModel.arithmeticParameter1.value?.toFloat() ?: 0F) + (mvpModel.arithmeticParameter2.value?.toFloat() ?: 0F)).toString()
    }

    override fun subtraction() {
        mvpModel.arithmeticParameter1.value = ((mvpModel.arithmeticParameter1.value?.toFloat() ?: 0F) - (mvpModel.arithmeticParameter2.value?.toFloat() ?: 0F)).toString()
    }

    override fun multiplication() {
        mvpModel.arithmeticParameter1.value = ((mvpModel.arithmeticParameter1.value?.toFloat() ?: 0F) * (mvpModel.arithmeticParameter2.value?.toFloat() ?: 0F)).toString()
    }

    override fun division() {
        mvpModel.arithmeticParameter1.value = ((mvpModel.arithmeticParameter1.value?.toFloat() ?: 0F) / (mvpModel.arithmeticParameter2.value?.toFloat() ?: 0F)).toString()
    }

}