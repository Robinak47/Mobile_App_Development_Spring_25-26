package com.example.fragmentexample

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
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

        btn=findViewById<Button>(R.id.btn)

        val firstFragmentManager: FragmentManager = supportFragmentManager
        val firstFragmentTransaction: FragmentTransaction = firstFragmentManager.beginTransaction()
        val firstFragment: Fragment = FirstFragment()
        firstFragmentTransaction.add(R.id.frame, firstFragment)
        firstFragmentTransaction.commit()

        btn.setOnClickListener {
            val secondFragmentManager: FragmentManager = supportFragmentManager
            val secondFragmentTransaction: FragmentTransaction = secondFragmentManager.beginTransaction()
            val secondFragment: Fragment = SecondFragment()
            secondFragmentTransaction.replace(R.id.frame, secondFragment)
            secondFragmentTransaction.addToBackStack(null);
            secondFragmentTransaction.commit()


        }
    }
}