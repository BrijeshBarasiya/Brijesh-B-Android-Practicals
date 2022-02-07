package com.example.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.basicofkotlin.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.cutom_toast.custom_toast
import kotlinx.android.synthetic.main.cutom_toast.view.tv_label
import kotlinx.android.synthetic.main.form_excercise.btn_submit
import kotlinx.android.synthetic.main.form_excercise.form_layout
import kotlinx.android.synthetic.main.form_excercise.img_done
import kotlinx.android.synthetic.main.form_excercise.sh_demo
import kotlinx.android.synthetic.main.form_excercise.tg_demo

class FormExercise : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_excercise)

        btn_submit.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Button Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        tg_demo.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked)
                Toast.makeText(applicationContext,"Toggle On", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(applicationContext,"Toggle Off", Toast.LENGTH_SHORT).show()
        }

        sh_demo.setOnClickListener {
            val snackbar = Snackbar.make(
                form_layout,
                if (sh_demo.isChecked) "Switch On" else "Switch Off",
                Snackbar.LENGTH_SHORT
            )
            snackbar.setAction(
                if (!sh_demo.isChecked) "Switch On" else "Switch Off",
                SnackbarEvent(sh_demo)
            )
            snackbar.show()
        }

        img_done.setOnClickListener {
            showCustomToast()
        }

    }

    fun showCustomToast() {
        val layoutInflater: LayoutInflater = layoutInflater
        val layout: View = layoutInflater.inflate(R.layout.cutom_toast, custom_toast)
        val labelToast: TextView = layout.tv_label
        val toast = Toast(applicationContext)

        labelToast.setText("Hello! I am Custom Toast")
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }

}