package com.example.basicofkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.intent_activity_fragment.IntentActivityFragment
import com.example.other_layout.FourExercise
import com.example.other_layout.NestedLayout
import com.example.recyclevier.RecyclerViewandAdapters
import com.example.uiwidgets.FormExercise
import com.example.uiwidgets.LayoutExercise
import com.example.webservices.LoginScreen
import kotlinx.android.synthetic.main.exercise_list.view.lbl_list_item

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
            exerciseLabel = view.lbl_list_item
            exerciseLabel.setOnClickListener{
                when(bindingAdapterPosition) {
                    0 -> {
                        var intent = Intent(view.context, FormExercise:: class.java)
                        view.context.startActivity(intent)
                    }
                    1 -> {
                        var intent = Intent(view.context, LayoutExercise:: class.java)
                        view.context.startActivity(intent)
                    }
                    2 -> {
                        var intent = Intent(view.context, RecyclerViewandAdapters:: class.java)
                        view.context.startActivity(intent)
                    }
                    3 -> {
                        var intent = Intent(view.context, IntentActivityFragment:: class.java)
                        view.context.startActivity(intent)
                    }
                    4 -> {
                        var intent = Intent(view.context, FourExercise:: class.java)
                        view.context.startActivity(intent)
                    }
                    5 -> {
                        var intent = Intent(view.context, LoginScreen:: class.java)
                        view.context.startActivity(intent)
                    }
                }
            }
        }

    }

}

