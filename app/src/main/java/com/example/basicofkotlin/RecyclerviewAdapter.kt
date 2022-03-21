package com.example.basicofkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.AndroidArchitecture
import com.example.fragment_datapassing.DataPassing
import com.example.intent_activity_fragment.IntentActivityFragment
import com.example.other_layout.FourExercise
import com.example.permission_model.PermissionModel
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
        
        val exerciseLabel: TextView = view.lbl_list_item

        init {
            exerciseLabel.setOnClickListener{
                when(bindingAdapterPosition) {
                    0 -> {
                        Intent(view.context, FormExercise:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                    1 -> {
                        Intent(view.context, LayoutExercise:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                    2 -> {
                        Intent(view.context, RecyclerViewandAdapters:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                    3 -> {
                        Intent(view.context, IntentActivityFragment:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                    4 -> {
                        Intent(view.context, FourExercise:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                    5 -> {
                        Intent(view.context, LoginScreen:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                    6 -> {
                        Intent(view.context, AndroidArchitecture:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                    7 -> {
                        Intent(view.context, PermissionModel:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                    8 -> {
                        Intent(view.context, DataPassing:: class.java).apply {
                            view.context.startActivity(this)
                        }
                    }
                }
            }
        }

    }

}

