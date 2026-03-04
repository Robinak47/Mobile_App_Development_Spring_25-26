package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView=findViewById<RecyclerView>(R.id.reCycler)
        recyclerView.layoutManager= LinearLayoutManager(this)

        var catNames=ArrayList<String>()
        var catImages=ArrayList<Int>()
        catNames.add("Meow1")
        catNames.add("meow2")
        catNames.add("Meow3")

        catImages.add(R.drawable.cat1)
        catImages.add(R.drawable.cat2)
        catImages.add(R.drawable.cat3)

        val adapter=CatAdapter(this,catNames,catImages)
        recyclerView.adapter=adapter


    }
}