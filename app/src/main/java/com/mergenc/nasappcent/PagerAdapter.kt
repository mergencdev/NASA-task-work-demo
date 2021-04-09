package com.mergenc.nasappcent

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return 3
        // Return 3 tabs;
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CuriosityFragment()
            1 -> OpportunityFragment()
            else -> return SpiritFragment()
        }
        // Set tabs position;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            1 -> "Curiosity"
            2 -> "Opportunity"
            else -> return "Spirit"
        }
        // Set tabs titles;
    }
}

// Curiosity, Opportunity, Spirit