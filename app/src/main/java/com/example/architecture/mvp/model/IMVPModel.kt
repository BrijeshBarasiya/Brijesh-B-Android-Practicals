package com.example.architecture.mvp.model

import androidx.lifecycle.MutableLiveData

interface IMVPModel {

    var arithmeticParameter1: MutableLiveData<String>
    var arithmeticParameter2: MutableLiveData<String>

}