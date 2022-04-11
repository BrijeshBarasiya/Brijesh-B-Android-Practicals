package com.example.webservices

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.R
import com.example.basicofkotlin.databinding.FourUserListBinding
import com.example.intent_activity_fragment.BaseURL
import com.example.intent_activity_fragment.retrofitBuilder
import kotlinx.android.synthetic.main.four_create_user.view.btn_delete
import kotlinx.android.synthetic.main.four_create_user.view.btn_submit
import kotlinx.android.synthetic.main.four_create_user.view.btn_update
import kotlinx.android.synthetic.main.four_create_user.view.txt_user_job
import kotlinx.android.synthetic.main.four_create_user.view.txt_user_name
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserList : AppCompatActivity() {

    //Variables
    private lateinit var binding: FourUserListBinding
    private lateinit var userInstance: ApiInterface
    lateinit var dialog: Dialog
    private lateinit var alertDialog: AlertDialog

    //Override Functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FourUserListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        dialog = Dialog(this)
        showDialog()
        getUserData()
        binding.fabAdduser.setOnClickListener {
            showCreateUser()
        }
    }

    //Other Functions
    private fun showCreateUser() {
        val dialogBox = AlertDialog.Builder(this)
        var inflator = this.layoutInflater
        var dialogView = inflator.inflate(R.layout.four_create_user, null)
        dialogView.btn_submit.setOnClickListener {
            if (validation(dialogView.txt_user_job, dialogView.txt_user_name)) {
                createUserData(dialogView.txt_user_job, dialogView.txt_user_name)
            }
        }
        dialogView.btn_update.setOnClickListener {
            if (validation(dialogView.txt_user_job, dialogView.txt_user_name)) {
                updateUser(dialogView.txt_user_job, dialogView.txt_user_name)
            }
        }
        dialogView.btn_delete.setOnClickListener {
            deleteUser()
        }
        dialogBox.setView(dialogView)
        alertDialog = dialogBox.create()
        alertDialog.show()
    }

    private fun showDialog() {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.four_custom_dialog)
        dialog.show()
    }

    private fun getUserData() {
        val retrofit = Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create()).build()
        userInstance = retrofit.create(ApiInterface::class.java)
        userInstance.allUserApi().apply {
            enqueue(object : Callback<UserDataValues> {
                override fun onResponse(call: Call<UserDataValues>, response: Response<UserDataValues>) {
                    val user: UserDataValues? = response.body()
                    if (user != null) {
                        val adapter = UserDataAdapter(user.data)
                        binding.userList.adapter = adapter
                        dialog.dismiss()
                    }
                }
                override fun onFailure(call: Call<UserDataValues>, t: Throwable) {
                    Log.d("Data", "Error")
                }
            })
        }
    }

    private fun validation(job: EditText, name: EditText): Boolean {
        var result = true
        if(job.text.toString().isEmpty()) {
            job.error = "Job Should not be Empty"
            result = false
        }
        if(name.text.toString().isEmpty()) {
            name.error = "Name Should not be Empty"
            result = false
        }
        return result
    }

    private fun createUserData(job: EditText, name: EditText) {
        val data = PostDataClass(job.text.toString(), name.text.toString())
        retrofitBuilder.createUser(data).apply {
            enqueue(object : Callback<PostResponseData> {
                override fun onResponse(call: Call<PostResponseData>, response: Response<PostResponseData>) {
                    when(response.code()) {
                        201 -> Toast.makeText(this@UserList, "User Added", Toast.LENGTH_SHORT).show()
                        else -> Toast.makeText(this@UserList, "Operation Failed", Toast.LENGTH_SHORT).show()
                    }
                    alertDialog.dismiss()
                }
                override fun onFailure(call: Call<PostResponseData>, t: Throwable) {
                    Toast.makeText(this@UserList, "Error", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun updateUser(job: EditText, name: EditText) {
        val data = PostDataClass(job.text.toString(), name.text.toString())
        retrofitBuilder.updateUser(data).apply {
            enqueue(object : Callback<PostResponseData> {
                override fun onResponse(call: Call<PostResponseData>, response: Response<PostResponseData>) {
                    when(response.code()) {
                        200 -> Toast.makeText(this@UserList, "User Updated", Toast.LENGTH_SHORT).show()
                        else -> Toast.makeText(this@UserList, "Operation Failed", Toast.LENGTH_SHORT).show()
                    }
                    alertDialog.dismiss()
                }
                override fun onFailure(call: Call<PostResponseData>, t: Throwable) {
                    Toast.makeText(this@UserList, "Error", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    private fun deleteUser() {
        retrofitBuilder.deleteUser().apply {
            enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    when(response.code()) {
                        204 -> Toast.makeText(this@UserList, "User Deleted", Toast.LENGTH_SHORT).show()
                        else -> Toast.makeText(this@UserList, "Operation Failed", Toast.LENGTH_SHORT).show()
                    }
                    alertDialog.dismiss()
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Toast.makeText(this@UserList, "Error", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

}