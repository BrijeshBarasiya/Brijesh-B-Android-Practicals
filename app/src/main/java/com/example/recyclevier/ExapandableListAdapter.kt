package com.example.recyclevier

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.exercise_list.view.lbl_list_item
import kotlinx.android.synthetic.main.three_c_listview_item.view.lstv_checkbox
import kotlinx.android.synthetic.main.three_c_listview_item.view.lstv_heading

class ExapandableListAdapter(
    private val elements: ArrayList<ExpandableListViewValues>
): BaseExpandableListAdapter() {

    override fun getGroupCount(): Int {
        return elements.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return elements[groupPosition].subList.size
    }

    override fun getGroup(groupPosition: Int): Any {
        return elements[groupPosition].headingList
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return elements[groupPosition].subList.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        val getTitle = getGroup(groupPosition) as String
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.three_c_listview_item, parent, false)
        val heading = view.lstv_heading
        val checkBox = view.lstv_checkbox
        checkBox.visibility = View.GONE
        heading.text = getTitle
        return view
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        val getSub = getChild(groupPosition, childPosition) as String
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.exercise_list, parent, false)
        val sub = view.lbl_list_item
        sub.text = getSub
        return view
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}