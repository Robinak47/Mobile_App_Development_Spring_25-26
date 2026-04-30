package com.example.firebaseauth

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductList : AppCompatActivity() {

    lateinit var pRview: RecyclerView
    lateinit var adapter: ProductAdapter

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val ref: DatabaseReference = database.getReference("products")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val products = ArrayList<Product>()

        pRview = findViewById(R.id.pRview)
        pRview.layoutManager = LinearLayoutManager(this)

        // ✅ Set adapter FIRST with the empty list
        adapter = ProductAdapter(this, products)
        pRview.adapter = adapter

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                // ✅ Clear old data to avoid duplicates on updates
                products.clear()

                for (eachProduct in snapshot.children) {
                    val product = Product(
                        eachProduct.child("code").value.toString(),
                        eachProduct.child("name").value.toString(),
                        eachProduct.child("catagory").value.toString(),
                        eachProduct.child("quantity").value.toString().toInt(),
                        eachProduct.child("price").value.toString().toFloat()
                    )
                    Log.d("product", "onDataChange: ${product.name}")
                    products.add(product)
                }

                // ✅ Tell the adapter new data is ready
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Error: ${error.message}")
            }
        })
    }
}