package com.example.expenses.expenses.tracking.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenses.expenses.tracking.CardInfo
import com.example.expenses.expenses.tracking.EmptyCard
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.`object`.Card
import com.example.expenses.expenses.tracking.`object`.Expense
import com.example.expenses.expenses.tracking.adapter.ExtractExpenseAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO_CACHE
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val expenseList = mutableListOf<Card>()

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

        expenseList.add(
            CardInfo(
                "123",
                "Teste",
                "123",
                "123"
            )
        )
        expenseList.add(EmptyCard())

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
                        "Mensalidade Faculdade",
                        "Educação",
                        false,
                        320.45
                    )
                )
            )
        }
    }

    private fun initButtons() {
        binding.btnAdd.setOnClickListener {
            activity?.run {
                baseContext.getSharedPreferences(THEME_INFO, Context.MODE_PRIVATE).apply {
                    edit {
                        putInt(THEME_INFO_CACHE, R.style.ExpensesTrackingDark)
                    }
                }
                recreate()
            }
        }
    }
}