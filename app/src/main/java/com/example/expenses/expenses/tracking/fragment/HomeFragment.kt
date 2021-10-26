package com.example.expenses.expenses.tracking.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.adapter.CardPagerAdapter
import com.example.expenses.expenses.tracking.adapter.ExtractExpenseAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding
import com.example.expenses.expenses.tracking.model.CardInfo
import com.example.expenses.expenses.tracking.model.EmptyCard
import com.example.expenses.expenses.tracking.model.Expense
import com.example.expenses.expenses.tracking.util.CardHolder
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO_CACHE
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

        CardHolder.cardList.add(
            CardInfo(
                "123",
                "Teste",
                "123",
                "123"
            )
        )

        CardHolder.cardList.add(EmptyCard())

        binding.cardList.apply {
            clipToPadding = false
            setPadding(35, 0, 35, 0)
            pageMargin = 15
            adapter = fragmentManager?.let {
                CardPagerAdapter(
                    it,
                    CardHolder.cardList
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