package com.example.snapzoo.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.snapzoo.R


class SecondScreen : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)
        val finish = view.findViewById<Button>(R.id.button_second_screen)

        finish.setOnClickListener{
            findNavController().navigate(R.id.action_onBoarding1Fragment_to_mainActivity)
        }
        return view
    }


}