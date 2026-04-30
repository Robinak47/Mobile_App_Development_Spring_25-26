package com.example.firebaseauth

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TestProductList : AppCompatActivity() {
    lateinit var loadBtn: Button

    var database: FirebaseDatabase= FirebaseDatabase.getInstance()
    val ref: DatabaseReference= database.getReference("products")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_test_product_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadBtn=findViewById<Button>(R.id.loadProduct)

        loadBtn.setOnClickListener {

            ref.addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    for(eachProduct in snapshot.children) {

                        if(eachProduct!==null)
                        {
                            val product: Product = Product(
                                eachProduct.child("code").value.toString(),
                                eachProduct.child("name").value.toString(),
                                eachProduct.child("catagory").value.toString(),
                                eachProduct.child("quantity").value.toString().toInt(),
                                eachProduct.child("price").value.toString().toFloat()
                            )
                            Log.d("product", "onDataChange: ${product.name}")
                            Log.d("product", "onDataChange: ${product.code}")
                            Log.d("product", "onDataChange: ${product.price}")
                            Log.d("product", "onDataChange: ${product.quantity}")
                            Log.d("product", "onDataChange: ${product.catagory}")

                        }


                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
            )
        }
    }

}


