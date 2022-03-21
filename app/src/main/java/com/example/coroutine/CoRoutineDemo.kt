package com.example.coroutine

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.basicofkotlin.R
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
        Log.d("Result", "printMe Function")
        Toast.makeText(applicationContext, "printMe Function", Toast.LENGTH_SHORT).show()
    }

    private suspend fun callingFunctionTwo() {
        delay(3000)
        Log.d("Result", "Main Thread is Running")
        Toast.makeText(applicationContext, "Main Thread is Running", Toast.LENGTH_SHORT).show()
    }

    private suspend fun asyncFunction() {
        var asyncTask = CoroutineScope(Dispatchers.Main).async {
            callingFunctionOne()
            callingFunctionTwo()
            delay(5000)
            callingFunctionOne()
            callingFunctionTwo()
            delay(5000)
            Log.d("Result", "OnCreate")
            Toast.makeText(applicationContext, "OnCreate", Toast.LENGTH_SHORT).show()
        }
        asyncTask.await()
    }

}