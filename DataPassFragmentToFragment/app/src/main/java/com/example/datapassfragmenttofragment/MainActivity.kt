package com.example.datapassfragmenttofragment

import android.app.FragmentManager
import android.os.Bundle
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

        var frgmentManager: androidx.fragment.app.FragmentManager =supportFragmentManager
        var fragementTransaction: androidx.fragment.app.FragmentTransaction = frgmentManager.beginTransaction()
        var firstFragment: FirstFragment =FirstFragment()
        fragementTransaction.add(R.id.frame, firstFragment)
        fragementTransaction.commit()




    }
}