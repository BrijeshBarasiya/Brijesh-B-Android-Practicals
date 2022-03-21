package com.example.architecture.mvp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MVPModel: ViewModel(), IMVPModel {

    override var arithmeticParameter1 =  MutableLiveData("0")
    override var arithmeticParameter2 = MutableLiveData("0")

}