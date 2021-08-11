package com.example.expenses.expenses.tracking.fragment

import CardPagerAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.model.Card
import com.example.expenses.expenses.tracking.adapter.ExtractExpenseAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding
import com.example.expenses.expenses.tracking.model.Expense
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO_CACHE
import java.util.*
import kotlin.collections.ArrayList

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


        binding.listaCartoes.apply {
            clipToPadding = false
            setPadding(35, 0, 35, 0)
            pageMargin = 15
            adapter = fragmentManager?.let {
                CardPagerAdapter(
                        it,
                       expenseList
                )
            }
        }

        binding.extrato.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ExtractExpenseAdapter(
                    arrayListOf(
                            Expense(
                                    1,
                                    Date(),
                                    "Mensalidade Condominio",
                                    "Moradia",
                                    false,
                                    550.80
                            ),
                            Expense(
                                    1,
                                    Date(),
                                    "Pix venda Video Game",
                                    "Venda",
                                    true,
                                    2500.00
                            ),

                            )
            )
        }
    }

    private fun initButtons() {
        binding.btnSearch.setOnClickListener {
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



