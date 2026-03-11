package com.example.fragmentlifecycle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("First Fragment", "on Create View Phase")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("First Fragment", "on Create Phase")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("First Fragment", "on View Created Phase")

    }

    override fun onStart() {
        super.onStart()
        Log.d("First Fragment", "on Start Phase")
    }

    override fun onResume() {
        super.onResume()
        Log.d("First Fragment", "on Resume Phase")
    }

    override fun onPause() {
        super.onPause()
        Log.d("First Fragment", "on Pause Phase")
    }

    override fun onStop() {
        super.onStop()
        Log.d("First Fragment", "on Stop Phase")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("First Fragment", "on Destroy View Phase")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("First Fragment", "on Detach Phase")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("First Fragment", "on Destroy Phase")

    }










}