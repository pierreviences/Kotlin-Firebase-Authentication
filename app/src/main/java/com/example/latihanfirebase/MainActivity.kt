package com.example.latihanfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanfirebase.adapter.ViewPagerAdapter
import com.example.latihanfirebase.databinding.ActivityMainBinding
import com.example.latihanfirebase.fragment.HomeFragment
import com.example.latihanfirebase.fragment.UserFragment
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
    }

    private fun setupTab(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(UserFragment(), "User")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.baseline_home_24)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.baseline_person_2_24)

    }
}