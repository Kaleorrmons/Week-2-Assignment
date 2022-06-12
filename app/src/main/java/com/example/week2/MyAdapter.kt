package com.example.week2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.week2.fragments.CreateEventFragment
import com.example.week2.fragments.HomeFragment
import com.example.week2.fragments.UpcomingEventsFragment

class MyAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment()
            1 -> return CreateEventFragment()
            2 -> return UpcomingEventsFragment()
            else -> return HomeFragment()
        }
    }
}