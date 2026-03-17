package com.example.activitytofragmentdatapass

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    lateinit var tf1: EditText
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tf1=findViewById<EditText>(R.id.tf1)
        btn=findViewById<Button>(R.id.btn)
        btn.setOnClickListener {

            val str= tf1.text.toString()
            val bundle=Bundle()
            bundle.putString("tf1Data", str)

            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction= fragmentManager.beginTransaction()
            val firstFragment : FirstFragment = FirstFragment()
            firstFragment.arguments=bundle
            fragmentTransaction.add(R.id.frame, firstFragment)
            fragmentTransaction.commit()
        }
    }
}