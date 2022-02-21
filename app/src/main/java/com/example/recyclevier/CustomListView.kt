package com.example.recyclevier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_listview_item.view.lstv_checkbox
import kotlinx.android.synthetic.main.three_c_listview_item.view.lstv_description
import kotlinx.android.synthetic.main.three_c_listview_item.view.lstv_heading
import kotlinx.android.synthetic.main.three_c_custom_listview.multiple_comp_listview

class CustomListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_custom_listview)
        val arrayAdapter: ArrayAdapter<CustomListViewValue> =
            object: ArrayAdapter<CustomListViewValue>(this, android.R.layout.simple_list_item_1, DataClass.customListViewValue) {
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    val view: View = LayoutInflater.from(context).inflate(R.layout.three_c_listview_item, parent, false)
                    val heading = view.lstv_heading
                    val description = view.lstv_description
                    val checkBox = view.lstv_checkbox
                    val element = DataClass.customListViewValue[position]
                    heading.text = element.heading
                    description.text = element.dscp
                    view.setOnClickListener{
                        checkBox.isChecked = !checkBox.isChecked
                    }
                    return view
                }
            }
        multiple_comp_listview.adapter = arrayAdapter
    }
    
}