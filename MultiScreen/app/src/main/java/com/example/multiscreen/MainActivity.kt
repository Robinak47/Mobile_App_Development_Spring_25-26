package com.example.multiscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var age: EditText
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

        name=findViewById<EditText>(R.id.nameId)
        age=findViewById<EditText>(R.id.ageid)
        btn=findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            val nameData=name.text.toString()
            val ageData=age.text.toString().toInt()
            var intent= Intent(this, SecondActivity::class.java)
            intent.putExtra("name",nameData)
            intent.putExtra("age",ageData)
            startActivity(intent)

            //Toast.makeText(this, "Name: $nameData, Age: $ageData", Toast.LENGTH_SHORT).show()

        }

    }
}