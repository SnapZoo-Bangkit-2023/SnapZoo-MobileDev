package com.example.snapzoo.screen.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.snapzoo.R
import com.example.snapzoo.adapter.ViewPagerAdapter
import com.example.snapzoo.screen.FirstScreen
import com.example.snapzoo.screen.SecondScreen
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class OnBoarding1Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_on_boarding1, container, false)
        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)

        viewPager.adapter = adapter
        val indicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)

        indicator.attachTo(viewPager)
        return view
    }



}