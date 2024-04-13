package com.example.onlineshop.ui.onboarding

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.onlineshop.R

class ViewPagerAdapter(val fragment: FragmentActivity):FragmentStateAdapter(fragment) {

    private val animeList= listOf(R.raw.onlineshopping,R.raw.orangedeliverytruck,R.raw.orangedeliverytruck)
    override fun getItemCount()=3

    override fun createFragment(position: Int)=
        OnBoardingChildFragment.newInstance(animeList[position])
}