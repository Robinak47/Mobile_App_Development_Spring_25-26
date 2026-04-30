package com.example.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.values

class MainActivity : AppCompatActivity() {
    lateinit var signUpBtn: Button
    lateinit var loginBtn: Button
    lateinit var email: EditText
    lateinit var  pass: EditText
    lateinit var forgetpass: Button
    var auth: FirebaseAuth= FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ageTF)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        signUpBtn = findViewById<Button>(R.id.signUpBtn)
        loginBtn = findViewById<Button>(R.id.loginBtn)
        email=findViewById<EditText>(R.id.emailTF)
        pass=findViewById<EditText>(R.id.passTF)
        forgetpass=findViewById<Button>(R.id.forgetPassBtn)


        signUpBtn.setOnClickListener {
            val intent= Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            auth.signInWithEmailAndPassword(email.text.toString(), pass.text.toString()).addOnCompleteListener { task ->
                if(task.isSuccessful) {
                   val database: FirebaseDatabase= FirebaseDatabase.getInstance()
                    val ref=database.getReference("users").child(auth.currentUser!!.uid)

                    ref.get().addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val snapshot = task.result
                            val role = snapshot.child("role").value.toString()
                            if (role == "student") {
                                val intent = Intent(this, StudentHome::class.java)
                                startActivity(intent)
                            }

                            else if(role=="admin") {
                               val intent= Intent(this, AdminHome::class.java)
                                startActivity(intent)
                            }

                            else {
                                Toast.makeText(this, "sorry", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this, "exception", Toast.LENGTH_SHORT).show()
                        }

                    }

                }
                else
                {
                    Toast.makeText(this, "exception", Toast.LENGTH_SHORT).show()

                }
            }
        }

        forgetpass.setOnClickListener {
            auth.sendPasswordResetEmail(email.text.toString()).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Email sent", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "exception", Toast.LENGTH_SHORT).show()
                }
            }
        }



        }

    }
