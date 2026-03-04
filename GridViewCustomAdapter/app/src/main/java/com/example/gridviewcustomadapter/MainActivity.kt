package com.example.gridviewcustomadapter

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var grid: GridView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        grid = findViewById<GridView>(R.id.grid)

        var studentNames = ArrayList<String>()
        var studentIds = ArrayList<String>()


        studentNames.add("Mr.Jack")
        studentNames.add("Mr. Tom");
        studentNames.add("Mr. meow")

        studentIds.add("101")
        studentIds.add("102")
        studentIds.add("103")

        val adapter = StudentAdapter(this, studentNames, studentIds)
        grid.adapter = adapter

        grid.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(this, "You clicked on ${studentNames[position]}", Toast.LENGTH_SHORT)
                .show()
        }
    }
}



