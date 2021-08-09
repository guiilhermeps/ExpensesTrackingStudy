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
import com.example.expenses.expenses.tracking.model.Card
import com.example.expenses.expenses.tracking.adapter.CardAdapter
import com.example.expenses.expenses.tracking.adapter.ExtractExpenseAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding
import com.example.expenses.expenses.tracking.model.Expense
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



