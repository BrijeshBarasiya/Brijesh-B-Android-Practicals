package com.example.coroutine

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.R
import com.example.intent_activity_fragment.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoRoutineDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.five_co_routine_demo)
        CoroutineScope(Dispatchers.Default).launch {
            asyncFunction()
        }
    }

    private suspend fun callingFunctionOne() {
        delay(3000)
        Log.d(Result, this.getString(R.string.print_me_fuction))
        Toast.makeText(applicationContext, this.getString(R.string.print_me_fuction), Toast.LENGTH_SHORT).show()
    }

    private suspend fun callingFunctionTwo() {
        delay(3000)
        Log.d(Result, resources.getString(R.string.main_thread_is_running))
        Toast.makeText(applicationContext, resources.getString(R.string.main_thread_is_running), Toast.LENGTH_SHORT).show()
    }

    private suspend fun asyncFunction() {
        var asyncTask = CoroutineScope(Dispatchers.Main).async {
            callingFunctionOne()
            callingFunctionTwo()
            delay(5000)
            callingFunctionOne()
            callingFunctionTwo()
            delay(5000)
            Log.d(Result, resources.getString(R.string.on_create))
            Toast.makeText(applicationContext, resources.getString(R.string.on_create), Toast.LENGTH_SHORT).show()
        }
        asyncTask.await()
    }

}