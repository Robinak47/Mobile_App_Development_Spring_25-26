package com.example.datapassfragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val  tf1= view.findViewById<EditText>(R.id.tf1)
        val  tf2= view.findViewById<EditText>(R.id.tf2)
        val  btn= view.findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            val str1= tf1.text.toString()
            val str2= tf2.text.toString()

            val bundle=Bundle()

            bundle.putString("tf1Data",str1)
            bundle.putString("tf2Data", str2)

            val secondFragment = SecondFragment()
            secondFragment.arguments = bundle

            parentFragmentManager.beginTransaction().replace(R.id.frame, secondFragment).commit()
        }
    }




}