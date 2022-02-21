package com.example.recyclevier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_playstore_item.view.playstore_app_recycler
import kotlinx.android.synthetic.main.three_c_playstore_item.view.playstore_title

class PlayStoreAdapter(
    private val elements: ArrayList<PlayStoreValues>
): RecyclerView.Adapter<PlayStoreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayStoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.three_c_playstore_item, parent, false)
        return PlayStoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayStoreViewHolder, position: Int) {
        val element: PlayStoreValues = elements[position]
        holder.playstore_title.text = element.title
        val adapter = GridRecyclerViewAdapter(PlayStore::class, position)
        holder.playstore_app_recycler.adapter = adapter
    }

    override fun getItemCount(): Int {
        return elements.size
    }

}

class PlayStoreViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val playstore_title = view.playstore_title
    val playstore_app_recycler = view.playstore_app_recycler

}