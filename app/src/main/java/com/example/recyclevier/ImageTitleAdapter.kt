package com.example.recyclevier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_image_title_item.view.app_image
import kotlinx.android.synthetic.main.three_c_image_title_item.view.app_title

class GridRecyclerViewAdapter<T>(
    private val type: T,
    private val index: Int
): RecyclerView.Adapter<GridRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.three_c_image_title_item, parent, false)
        return GridRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridRecyclerViewHolder, position: Int) {
        when(type) {
            GridRecyclerView::class -> {
                val element = DataClass.gridRecyclerViewValues[position]
                holder.itm_title.text = element.title
                holder.itm_img.setImageResource(element.img)
            }
            PlayStore::class -> {
                val apps = DataClass.playStoreValues[index].apps
                val element = apps[position]
                holder.itm_title.text = element.title
                holder.itm_img.setImageResource(element.img)
            }
        }
    }

    override fun getItemCount(): Int {
        return when (type) {
            GridRecyclerView::class -> DataClass.gridRecyclerViewValues.size
            PlayStore::class -> DataClass.playStoreValues[index].apps.size
            else -> return 0
        }
    }

}

class GridRecyclerViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val itm_title =  view.app_title
    val itm_img = view.app_image

}
