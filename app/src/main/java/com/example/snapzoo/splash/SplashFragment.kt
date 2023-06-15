package com.example.snapzoo.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.snapzoo.R


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Handler(Looper.getMainLooper()).postDelayed({
           findNavController().navigate(R.id.action_splashFragment_to_onBoarding1Fragment)
        },2000)
        val view =  inflater.inflate(R.layout.fragment_splash, container, false)

        return view
    }


}