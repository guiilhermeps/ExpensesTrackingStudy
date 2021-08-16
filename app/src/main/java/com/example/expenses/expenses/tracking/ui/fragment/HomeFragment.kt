package com.example.expenses.expenses.tracking.ui.fragment

import android.content.Context
import android.os.Bundle
import android.provider.Settings.Global.putInt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.`object`.Card
import com.example.expenses.expenses.tracking.`object`.Expense
import com.example.expenses.expenses.tracking.adapter.CardPagerAdapter
import com.example.expenses.expenses.tracking.adapter.ExtractExpenseAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding
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
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initButtons()

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


        binding.extractHistory.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ExtractExpenseAdapter(
                arrayListOf(
                    Expense(
                        1,
                        Date(),
                        "Mensalidade Faculdade",
                        "Educação",
                        false,
                        187.89
                    ),

                    Expense(
                        1,
                        Date(),
                        "Mensalidade Condominio",
                        "Moradia",
                        false,
                        320.47
                    )
                )
            )
        }

    }

    private fun initButtons(){
        binding.btnAdd.setOnClickListener{
            activity?.run {
                baseContext.getSharedPreferences(THEME_INFO, Context.MODE_PRIVATE).apply {
                    edit{
                        putInt(THEME_INFO_CACHE, R.style.ExpensesTrackingDark)
                    }
                }
                recreate()
            }
        }
    }

}