package com.example.expenses.expenses.tracking.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.`object`.Card
import com.example.expenses.expenses.tracking.adapter.CardPagerAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.pagerCard.apply {
            clipToPadding = false
            setPadding(35, 0, 35, 0)
            pageMargin = 15
            adapter = fragmentManager?.let { fragmentManager ->
                CardPagerAdapter(
                    fragmentManager,
                    arrayListOf(
                        Card(
                            "**** 0420",
                            "R$ 823,00",
                            "R$ 75,00",
                            "50,00"
                        ),
                        Card(
                            "**** 8750",
                            "R$ 1200,00",
                            "R$ 42,00",
                            "34,40"
                        ), Card(
                            "**** 9087",
                            "R$ 823,00",
                            "R$ 87,28",
                            "41,90"
                        )
                    )
                )
            }
        }

    }

}