package com.mergenc.nasappcent.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mergenc.nasappcent.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set toolbar title;
        toolBar.setTitle("Mars Rover Photos")
        setSupportActionBar(toolBar)

        // Set adapter;
        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter

        // Tablayout with viewpager;
        tabLayout.setupWithViewPager(viewPager)
    }
}