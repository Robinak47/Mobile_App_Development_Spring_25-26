package com.example.retrofittestproj

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //showPosts()
        //loginProcess()
        createusers()


    }

    fun showPosts()
    {
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(
            GsonConverterFactory.create()).build()


        val retrofitApi = retrofit.create(RetrofitApi::class.java)
        val call = retrofitApi.getAllPosts()

        call.enqueue(object: Callback<List<Posts>> {
            override fun onResponse(
                p0: Call<List<Posts>?>,
                p1: Response<List<Posts>?>
            ) {
                val posts = p1.body()
                if (posts != null) {
                    for (post in posts) {
                        Log.d("MainActivity", "Post title: ${post.title}")
                        Log.d("MainActivity", "Post body: ${post.body}")
                    }

                }
            }

            override fun onFailure(
                p0: Call<List<Posts>?>,
                p1: Throwable
            ) {
                Toast.makeText(this@MainActivity, "Error fetching posts", Toast.LENGTH_SHORT).show()
            }

        }
        )



    }

    fun loginProcess() {

        val retrofit = Retrofit.Builder().baseUrl("http://10.90.255.221:3000").addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        val retrofitApi = retrofit.create(RetrofitApi::class.java)
        val login = Login("meow1@aiub.edu", "12345678")
        val call = retrofitApi.createPost(login).enqueue(object : Callback<Login> {
            override fun onResponse(
                p0: Call<Login?>,
                p1: Response<Login?>
            ) {
                Log.d("MainActivity", "login successfull")
            }

            override fun onFailure(
                p0: Call<Login?>,
                p1: Throwable
            ) {
                Log.d("MaimActivity,",  "Error while Login")
                Log.d("error trece", p1.toString())
            }


        }
        )
    }

    fun createusers() {

        val retrofit = Retrofit.Builder().baseUrl("http://10.90.255.221:3000").addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        val retrofitApi = retrofit.create(RetrofitApi::class.java)
        val user = User(6, "meow3@aiub.edu", "12345678", "admin")
        val call = retrofitApi.createUser(user).enqueue(object : Callback<User> {
            override fun onResponse(
                p0: Call<User?>,
                p1: Response<User?>
            ) {
                Log.d("MainActivity", "User created successfully")
            }

            override fun onFailure(
                p0: Call<User?>,
                p1: Throwable
            ) {
                Log.d("MaimActivity,",  "Error while creating user")
                Log.d("error trece", p1.toString())
            }


        }
        )
    }
}