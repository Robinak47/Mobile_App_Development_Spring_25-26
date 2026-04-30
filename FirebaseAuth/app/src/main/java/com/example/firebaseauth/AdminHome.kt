package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AdminHome : AppCompatActivity() {

    lateinit var addProduct: Button
    lateinit var deleteProduct: Button
    lateinit var updateProduct: Button
    lateinit var productListBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_admin_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        addProduct = findViewById<Button>(R.id.addProduct)
        deleteProduct = findViewById<Button>(R.id.deleteProduct)
        updateProduct = findViewById<Button>(R.id.updateProduct)
        productListBtn =findViewById<Button>(R.id.productListBtn)

        addProduct.setOnClickListener {
            val intent = Intent(this, AddProduct::class.java)
            startActivity(intent)

        }

        deleteProduct.setOnClickListener {
            val intent = Intent(this, DeleteProduct::class.java)
            startActivity(intent)

        }

        updateProduct.setOnClickListener {
            val intent = Intent(this, AddProduct::class.java)
            startActivity(intent)


        }


        productListBtn.setOnClickListener {

            val intent = Intent(this, ProductList::class.java)
            startActivity(intent)

        }
    }
}