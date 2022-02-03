package com.example.uiwidgets

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.example.basicofkotlin.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.cutom_toast.customToast
import kotlinx.android.synthetic.main.cutom_toast.view.tvLabel
import kotlinx.android.synthetic.main.form_excercise.btnSubmit
import kotlinx.android.synthetic.main.form_excercise.formLayout
import kotlinx.android.synthetic.main.form_excercise.imgDone
import kotlinx.android.synthetic.main.form_excercise.shDemo
import kotlinx.android.synthetic.main.form_excercise.tgDemo

class FormExercise : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_excercise)

        btnSubmit.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Button Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        tgDemo.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked)
                Toast.makeText(applicationContext,"Toggle On", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(applicationContext,"Toggle Off", Toast.LENGTH_SHORT).show()
        }

        shDemo.setOnClickListener {
            val snackbar = Snackbar.make(
                formLayout,
                if (shDemo.isChecked) "Switch On" else "Switch Off",
                Snackbar.LENGTH_SHORT
            )
            snackbar.setAction(
                if (!shDemo.isChecked) "Switch On" else "Switch Off",
                SnackbarEvent(shDemo)
            )
            snackbar.show()
        }

        imgDone.setOnClickListener {
            showCustomToast()
        }

    }

    @SuppressLint("SetTextI18n")
    fun showCustomToast() {
        val layoutInflater: LayoutInflater = layoutInflater
        val layout: View = layoutInflater.inflate(R.layout.cutom_toast, customToast)
        val labelToast: TextView = layout.tvLabel
        val toast = Toast(applicationContext)

        labelToast.setText("Hello! I am Custom Toast")
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }

}