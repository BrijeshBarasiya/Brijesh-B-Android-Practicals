package com.example.recyclevier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_expandable_recyclerview_item.view.rclv_itm
import kotlinx.android.synthetic.main.three_c_expandable_recyclerview_item.view.rclv_itm_expd_text
import kotlinx.android.synthetic.main.three_c_expandable_recyclerview_item.view.rclv_itm_hdr_img
import kotlinx.android.synthetic.main.three_c_expandable_recyclerview_item.view.rclv_itm_hdr_txt

class ExpandableRecyclerViewAdapter(
    private val elements: ArrayList<ExpandableRecyclerViewValues>
): RecyclerView.Adapter<ExpandableRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpandableRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.three_c_expandable_recyclerview_item, parent, false)
        return ExpandableRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpandableRecyclerViewHolder, position: Int) {
        val element: ExpandableRecyclerViewValues = elements[position]
        holder.itm_hdr_img.setImageResource(element.image)
        holder.itm_hdr_txt.text =  element.title
        holder.itm_expd_text.text = element.subData
        holder.itm.setOnClickListener {
            if (holder.itm_expd_text.visibility == View.GONE)
                holder.itm_expd_text.visibility = View.VISIBLE
            else
                holder.itm_expd_text.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return elements.size
    }

}

class ExpandableRecyclerViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val itm_hdr_img = view.rclv_itm_hdr_img
    val itm_hdr_txt = view.rclv_itm_hdr_txt
    val itm_expd_text = view.rclv_itm_expd_text
    val itm = view.rclv_itm

}