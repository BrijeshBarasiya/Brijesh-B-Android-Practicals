package com.example.webservices

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.basicofkotlin.R
import com.example.intent_activity_fragment.UserID
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.four_user_details_item.view.cellLayour
import kotlinx.android.synthetic.main.four_user_details_item.view.imv_profile_image
import kotlinx.android.synthetic.main.four_user_details_item.view.lbl_user_email
import kotlinx.android.synthetic.main.four_user_details_item.view.lbl_user_name

//Recyclerview Adapter
class UserDataAdapter(
    private val elements: List<Data>
): RecyclerView.Adapter<UserDataViewHolder>() {

    //Implement Function
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.four_user_details_item, parent, false)
        return UserDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        val element: Data = elements[position]
        val fullName = "${element.firstName} ${element.lastName}"
        holder.userName.text = fullName
        holder.userEmail.text = element.email
        Picasso.get().load(element.avatar).into(holder.userAvatar)
        holder.layout.setOnClickListener {
            val intent = Intent(holder.itemView.context, SingleUser::class.java)
            intent.putExtra(UserID, element.id)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return elements.size
    }

}

//ViewHolder Class
class UserDataViewHolder(view: View): RecyclerView.ViewHolder(view) {

    //Variables
    var userName: TextView = view.lbl_user_name
    var userEmail: TextView = view.lbl_user_email
    var userAvatar: ImageView = view.imv_profile_image
    var layout: ConstraintLayout = view.cellLayour

    init {
        layout.setOnClickListener {
            val intent = Intent(view.context, SingleUser::class.java)
            view.context.startActivity(intent)
        }
    }

}