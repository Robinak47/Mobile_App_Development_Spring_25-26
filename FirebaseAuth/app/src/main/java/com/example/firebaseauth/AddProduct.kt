package com.example.firebaseauth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.FirebaseDatabase

class AddProduct : AppCompatActivity() {

    lateinit var codeTF: EditText
    lateinit var nameTf: EditText
    lateinit var catagoryTf: EditText
    lateinit var quantityTf: EditText
    lateinit var priceTf: EditText

    lateinit var submitBtn: Button
    lateinit var resetBtn: Button

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val ref = database.getReference("products")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_product)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        codeTF = findViewById<EditText>(R.id.codeTF)
        nameTf = findViewById<EditText>(R.id.nameTf)
        catagoryTf = findViewById<EditText>(R.id.catagoryTf)
        quantityTf = findViewById<EditText>(R.id.quantityTf)
        priceTf = findViewById<EditText>(R.id.priceTf)

        submitBtn = findViewById<Button>(R.id.submitBtn)
        resetBtn= findViewById<Button>(R.id.resetBtn)

        submitBtn.setOnClickListener {
            val code = codeTF.text.toString()
            val name = nameTf.text.toString()
            val catagory = catagoryTf.text.toString()
            val quantity = quantityTf.text.toString().toInt()
            val price = priceTf.text.toString().toFloat()

            val product: Product= Product(code, name, catagory, quantity, price)

            ref.child(product.code).setValue(product).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "product inserted", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    Toast.makeText(this, "exception", Toast.LENGTH_SHORT).show()

                }
            }


        }

        resetBtn.setOnClickListener {
            codeTF.setText("")
            nameTf.setText("")
            catagoryTf.setText("")
            quantityTf.setText("")
            priceTf.setText("")

        }










    }
}