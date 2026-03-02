package com.example.gridview

import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var grd: GridView
    lateinit var main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        grd = findViewById<GridView>(R.id.grd)
        main=findViewById<ConstraintLayout>(R.id.cMain)

        var students = arrayOf("meow1", "meow2", "meow3", "moew4")

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, students)

        grd.adapter = adapter

        grd.setOnItemClickListener { parent, view, position, id ->
            //Toast.makeText(this, "Clicked on " + students[position], Toast.LENGTH_SHORT).show()
            var snack=Snackbar.make(main, "Clicked on " + students[position], Snackbar.LENGTH_INDEFINITE).setAction("Close")
            {
            }

            snack=snack.setBackgroundTint(Color.RED)
            snack=snack.setTextColor(Color.WHITE)
            snack.show()
        }

    }
}


