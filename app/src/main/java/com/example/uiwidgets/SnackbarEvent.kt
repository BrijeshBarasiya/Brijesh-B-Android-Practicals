package com.example.uiwidgets

import android.view.View
import android.widget.Switch

class SnackbarEvent(val swt: Switch) : View.OnClickListener {

    override fun onClick(v: View) {
        if (swt.isChecked) swt.isChecked = false else swt.isChecked = true
    }

}