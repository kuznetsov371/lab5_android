package com.lab5.lab5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.lab5.lab5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = MyAdapter(this)

        TabLayoutMediator(binding.tabLayout,binding.pager){ tab, pos ->
            tab.text = "Page №$pos"
        }.attach()
    }

    class MyAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
        private val list = arrayListOf(
            FragmentMainFirst.newInstance(0),
            FragmentMainFirst.newInstance(1),
            FragmentMainFirst.newInstance(2 ),
        )

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment = list[position]
    }
}