package com.example.expenses.expenses.tracking.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.expenses.expenses.tracking.`object`.Card
import com.example.expenses.expenses.tracking.fragment.CardAdapterFragment

class CardPagerAdapter(
    fragmentManager: FragmentManager,
    private val cardsList: ArrayList<Card>
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = cardsList.size

    override fun getItem(position: Int): Fragment {
        return CardAdapterFragment(cardsList[position])
    }
}


