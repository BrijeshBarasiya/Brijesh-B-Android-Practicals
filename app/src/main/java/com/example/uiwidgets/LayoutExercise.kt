package com.example.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.layout_exercise.demo_constraint_layout
import kotlinx.android.synthetic.main.layout_exercise.demo_frame_layout
import kotlinx.android.synthetic.main.layout_exercise.demo_grid_layout
import kotlinx.android.synthetic.main.layout_exercise.demo_linear_layout
import kotlinx.android.synthetic.main.layout_exercise.demo_relative_layout
import kotlinx.android.synthetic.main.layout_exercise.demo_tab_layout
import kotlinx.android.synthetic.main.layout_exercise.demo_table_layout

class LayoutExercise : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_exercise)
        demo_linear_layout.setOnClickListener {
            var intent = Intent(applicationContext, LinearLayoutDemo:: class.java)
            startActivity(intent)
        }
        demo_constraint_layout.setOnClickListener {
            var intent = Intent(applicationContext, ConstrainLayoutDemo:: class.java)
            startActivity(intent)
        }
        demo_relative_layout.setOnClickListener {
            var intent = Intent(applicationContext, RelativeLayoutDemo:: class.java)
            startActivity(intent)
        }
        demo_frame_layout.setOnClickListener {
            var intent = Intent(applicationContext, FrameLayoutDemo:: class.java)
            startActivity(intent)
        }
        demo_table_layout.setOnClickListener {
            var intent = Intent(applicationContext, TableLayoutDemo:: class.java)
            startActivity(intent)
        }
        demo_grid_layout.setOnClickListener {
            var intent = Intent(applicationContext, GridLayoutDemo:: class.java)
            startActivity(intent)
        }
        demo_tab_layout.setOnClickListener {
            var intent = Intent(applicationContext, TabLayoutDemo:: class.java)
            startActivity(intent)
        }
    }

}