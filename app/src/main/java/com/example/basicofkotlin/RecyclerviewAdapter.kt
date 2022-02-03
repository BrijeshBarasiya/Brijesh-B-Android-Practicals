package com.example.basicofkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uiwidgets.FormExercise
import kotlinx.android.synthetic.main.exercise_list.view.lblListItem

class RecyclerviewAdapter(val labelList: List<String>): RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exercise_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.exerciseLabel.text = labelList[position]
    }

    override fun getItemCount(): Int {
        return labelList.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        
        val exerciseLabel: TextView
        init {
            exerciseLabel = view.lblListItem
            exerciseLabel.setOnClickListener{
                when(exerciseLabel.text) {
                    "Chapter: 3(A) Ui Widgets" -> {
                        var intent = Intent(view.context, FormExercise:: class.java)
                        view.context.startActivity(intent)
                    }
                }
            }
        }

    }

}

