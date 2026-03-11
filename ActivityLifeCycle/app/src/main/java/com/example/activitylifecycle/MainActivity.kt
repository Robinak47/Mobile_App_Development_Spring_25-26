package com.example.activitylifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d("main Activity","On create Phase")
    }

    override fun onStart() {
        super.onStart()
        Log.d("main Activity","On Start Phase")

    }

    override fun onResume() {
        super.onResume()
        Log.d("main Activity","On Resume Phase")

    }

    override fun onPause() {
        super.onPause()
        Log.d("main Activity","On Pause Phase")

    }

    override fun onStop() {
        super.onStop()
        Log.d("main Activity","On Stop Phase")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("main Activity","On Destroy Phase")

    }





}