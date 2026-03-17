package com.example.datapassfragmenttofragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tb1= view.findViewById<TextView>(R.id.tb1)
        val tb2=view.findViewById<TextView>(R.id.tb2)

        val bundle= arguments

        tb1.setText(bundle?.getString("tf1Data"))
        tb2.setText(bundle?.getString("tf2Data"))


    }


}