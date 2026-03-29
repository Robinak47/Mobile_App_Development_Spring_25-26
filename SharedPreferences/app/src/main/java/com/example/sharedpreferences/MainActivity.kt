package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var  tf: EditText
    lateinit var  btn: Button
    lateinit var tb: TextView


    lateinit var  sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tf=findViewById<EditText>(R.id.tf)
        tb=findViewById<TextView>(R.id.tb)
        btn=findViewById<Button>(R.id.btn)
        var count=0
        btn.setOnClickListener {
            count++
            tb.text=count.toString()
        }



    }

    override fun onPause() {
        super.onPause()

        saveData()

    }

    override fun onResume() {
        super.onResume()

        retrieveData()
    }


    fun saveData()
    {
        sharedPreferences= getSharedPreferences("myFile", Context.MODE_PRIVATE)
        val editor= sharedPreferences.edit()

        val value= tf.text.toString()
        val counter=tb.text.toString()
        editor.putString("key1", value)
        editor.putString("key2", counter)
        editor.apply()
    }

    fun retrieveData()
    {
        sharedPreferences= getSharedPreferences("myFile", Context.MODE_PRIVATE)
        val value= sharedPreferences.getString("key1", "")
        val counter =sharedPreferences.getString("key2","0")
        tf.setText(value)
        tb.setText(counter)
    }
}