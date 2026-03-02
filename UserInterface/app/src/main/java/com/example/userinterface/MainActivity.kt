package com.example.userinterface

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var img: ImageView
    lateinit var btn: Button
    lateinit var redRadio: RadioButton
    lateinit var greenRadio: RadioButton

    lateinit var layoutMain: ConstraintLayout

    lateinit var tgB: ToggleButton
    lateinit var tb3: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layoutMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        img=findViewById<ImageView>(R.id.imgV)
        btn=findViewById<Button>(R.id.btn)

        redRadio=findViewById<RadioButton>(R.id.red)
        greenRadio=findViewById<RadioButton>(R.id.green)
        layoutMain=findViewById<ConstraintLayout>(R.id.layoutMain)
        tgB=findViewById<ToggleButton>(R.id.tgButton)
        tb3=findViewById<TextView>(R.id.tb3)




        btn.setOnClickListener {
            img.setImageResource(R.drawable.samsung)

            var value: String=""
            if(redRadio.isChecked){
                value="red"
            }
            else if(greenRadio.isChecked){
                value="green"
            }
            else
            {

            }

            Toast.makeText(/* context = */ this,/* text = */ value,/* duration = */ Toast.LENGTH_SHORT).show()


        }

        tgB.setOnCheckedChangeListener {
            buttonView, isChecked ->
            if(isChecked){
                img.visibility= ImageView.VISIBLE
            }
            else{
                img.visibility= ImageView.INVISIBLE
            }
        }


        tb3.setOnClickListener {
            Toast.makeText(this, "on text View", Toast.LENGTH_SHORT).show()
        }

        btn.setOnLongClickListener { view ->
            Toast.makeText(this, "on long click", Toast.LENGTH_SHORT).show()
            true

        }






//        redRadio.setOnClickListener {
//            layoutMain.setBackgroundColor(Color.RED)
//
//        }
//
//        greenRadio.setOnClickListener {
//            layoutMain.setBackgroundColor(Color.GREEN)
//        }



    }
}