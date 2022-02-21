package com.example.intent_activity_fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass: ViewModel() {

    val message = MutableLiveData("")
    var fragment: Fragment = Gallery()

}