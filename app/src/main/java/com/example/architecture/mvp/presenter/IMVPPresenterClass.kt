package com.example.architecture.mvp.presenter

import com.example.architecture.mvp.model.MVPModel

interface IMVPPresenterClass {

    fun setValue(values: MVPModel)
    fun addition()
    fun subtraction()
    fun multiplication()
    fun division()

}