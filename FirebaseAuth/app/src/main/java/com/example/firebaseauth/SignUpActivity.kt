package com.example.firebaseauth

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    lateinit var signUpBtn: Button
    lateinit var emailTf: EditText
    lateinit var passTf: EditText

    lateinit var nameTf: EditText
    lateinit var  ageTf: EditText



    var auth: FirebaseAuth = FirebaseAuth.getInstance()

    var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val ref = database.getReference("users")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ageTF)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        signUpBtn = findViewById<Button>(R.id.submit)
        emailTf = findViewById<EditText>(R.id.emailTf)
        passTf = findViewById<EditText>(R.id.passTf)
        nameTf=findViewById<EditText>(R.id.name)
        ageTf=findViewById<EditText>(R.id.age)


        signUpBtn.setOnClickListener {
         signUp(emailTf.text.toString(), passTf.text.toString())
        }
    }

    fun signUp(email: String, pass: String) {
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
            if (task.isSuccessful) {

                val name = nameTf.text.toString()
                val age = ageTf.text.toString().toInt()

               val user: User= User(name, age, email, "student")

                ref.child(auth.currentUser!!.uid).setValue(user).addOnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()

                    }
                    else
                    {

                        Toast.makeText(this, "exception", Toast.LENGTH_SHORT).show()

                    }
                }



//                Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
           finish()
            } else {
                Toast.makeText(this, "exception", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

    }
}


