package com.example.recyclevier

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import com.example.basicofkotlin.R
import kotlinx.android.synthetic.main.three_c_condition_based_list_view.condition_listview

class ConditionBasedListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_c_condition_based_list_view)
        var arrayList = ArrayList<String>()
        arrayList.add("Item 1")
        arrayList.add("Item 2")
        arrayList.add("Item 3")
        arrayList.add("Item 4")
        arrayList.add("Item 5")
        arrayList.add("Item 6")
        arrayList.add("Item 7")
        val arrayAdapter: ArrayAdapter<String> =
            object: ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList) {
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    val view = super.getView(position, convertView, parent)
                    if (position % 2 == 0)
                        view.setBackgroundColor(ContextCompat.getColor(context, R.color.teal_200))
                    else
                        view.setBackgroundColor(ContextCompat.getColor(context, R.color.backGound))
                    return view
                }
            }
        condition_listview.adapter = arrayAdapter
    }

}