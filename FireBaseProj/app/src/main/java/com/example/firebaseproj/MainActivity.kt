package com.example.firebaseproj

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    lateinit var tf1: EditText
    lateinit var tf2: EditText
    lateinit var  btn: Button
    lateinit var tb1: TextView
    lateinit var tb2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tf1= findViewById<EditText>(R.id.tf1)
        tf2=findViewById<EditText>(R.id.tf2)
        btn=findViewById<Button>(R.id.btn)
        tb1=findViewById<TextView>(R.id.tb1)
        tb2=findViewById<TextView>(R.id.tb2)

        var database: FirebaseDatabase = FirebaseDatabase.getInstance()
        var databaseReference: DatabaseReference = database.getReference().child("users")





        btn.setOnClickListener {
            var name= tf1.text.toString()
            var age=tf2.text.toString().toInt()



            databaseReference.child("user4").child("name").setValue(name)
            databaseReference.child("user4").child("age").setValue(age)
            var ref2: DatabaseReference = database.getReference().child("users").child("user4")
            ref2.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var name = snapshot.child("name").getValue()
                    var age = snapshot.child("age").getValue()

                    tb1.text = name.toString()
                    tb2.text = age.toString()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            }
            )

        }









    }
}