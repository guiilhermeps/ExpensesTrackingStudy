package com.example.expenses.expenses.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.`object`.Card
import com.example.expenses.expenses.tracking.adapter.CardAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.listaCartoes.apply {
            clipToPadding = false
            setPadding(35, 0, 35, 0)
            pageMargin = 15
            adapter = fragmentManager?.let {
                CardAdapter(
                    it,
                    arrayListOf(
                        Card(
                            "**** 9389",
                            "R$ 250,00",
                            "R$ 100,00",
                            "R$ 50,00"
                        ),
                        Card(
                            "**** 7348",
                            "R$ 1000,00",
                            "R$ 500,00",
                            "R$ 50,00"
                        ),
                        Card(
                            "**** 3483",
                            "R$ 2000,00",
                            "R$ 500,00",
                            "R$ 50,00"
                        )
                    )
                )
            }
        }
    }
}

