package com.example.expenses.expenses.tracking.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.model.Card
import com.example.expenses.expenses.tracking.adapter.CardPagerAdapter
import com.example.expenses.expenses.tracking.adapter.ExtractExpenseAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding
import com.example.expenses.expenses.tracking.model.Expense
import java.util.*

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

        initButtons()

        binding.cardList.apply {
            clipToPadding = false
            setPadding(35, 0, 35, 0)
            pageMargin = 15
            adapter = fragmentManager?.let {
                CardPagerAdapter(
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

        binding.extractHistory.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ExtractExpenseAdapter(
                arrayListOf(
                    Expense(
                        1,
                        Date(),
                        "Mensalidade Condominio",
                        "Moradia",
                        false,
                        545.75
                    ),
                    Expense(
                        1,
                        Date(),
                        "Pix venda Video Game",
                        "Venda",
                        true,
                        2500.00
                    )
                )
            )
        }
    }

    private fun initButtons() {
        binding.buttonAddExpense.setOnClickListener {
            activity?.run {
                val sharedPreferences = baseContext.getSharedPreferences("themeInfo", Context.MODE_PRIVATE)
                sharedPreferences.edit {
                    putInt("InfoThemeInCache", R.style.ExpensesTrackingDark)
                }
            }
        }
    }
}