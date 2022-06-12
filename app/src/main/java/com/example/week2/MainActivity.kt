package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.week2.fragments.CreateEventFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    var tabTitle = arrayOf("Home","Create Event","Upcoming Events")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_create_event)

        var pager = findViewById<ViewPager2>(R.id.viewPager2)
        var tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        pager.adapter = MyAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator (tabLayout, pager){
                tab, position ->
            tab.text = tabTitle[position]

            fun passDataCom(editTextInput: String) {
                val bundle = Bundle()
                bundle.putString("message", editTextInput)

                val transaction = this.supportFragmentManager.beginTransaction()
                val createMessageFragment = CreateEventFragment()
                createMessageFragment.arguments = bundle

                transaction.replace(R.id.viewPager2, createMessageFragment)
                transaction.commit()}

        }.attach()
    }

}