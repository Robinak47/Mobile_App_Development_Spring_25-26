package com.example.firebaseauth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteProduct : AppCompatActivity() {

    lateinit var codeTf: EditText
    lateinit var deleteBtn: Button

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val ref: DatabaseReference = database.getReference("products")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_delete_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        codeTf = findViewById<EditText>(R.id.codeTf)
        deleteBtn = findViewById<Button>(R.id.deleteBtn)

        deleteBtn.setOnClickListener {
            val code = codeTf.text.toString()
            ref.child(code).removeValue().addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    Toast.makeText(this, "product deleted successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "exception", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}