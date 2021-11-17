package com.example.expenses.expenses.tracking.fragment.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expenses.expenses.tracking.MyApp
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.adapter.ExtractExpenseAdapter
import com.example.expenses.expenses.tracking.adapter.card.CardPagerAdapter
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding
import com.example.expenses.expenses.tracking.model.card.Card
import com.example.expenses.expenses.tracking.model.expenses.Expense
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO
import com.example.expenses.expenses.tracking.util.StringUtils.THEME_INFO_CACHE
import com.example.expenses.expenses.tracking.viewmodel.home.HomeViewAction
import com.example.expenses.expenses.tracking.viewmodel.home.HomeViewModel
import com.example.expenses.expenses.tracking.viewmodel.home.HomeViewModelFactory
import com.example.expenses.expenses.tracking.viewmodel.home.HomeViewState
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

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
        viewModel = ViewModelProvider(
            this, HomeViewModelFactory(
                (activity?.application as MyApp)
            )
        ).get(HomeViewModel::class.java)

        initButtons()
        setupObservers()

        viewModel.dispatchViewAction(HomeViewAction.RetrieveSavedCards)
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

    private fun setupObservers() {
        viewModel.viewState.observe(this, {
            when (it) {
                is HomeViewState.CardsLoaded -> setupCardsView(it.cardList ?: listOf())
                is HomeViewState.ExpensesLoaded -> setupExpenses(it.expensesList ?: listOf())
            }
        })

        viewModel.viewAction.observe(this, {})
    }

    private fun setupCardsView(cardsList: List<Card>) {
        binding.cardList.apply {
            clipToPadding = false
            setPadding(35, 0, 35, 0)
            pageMargin = 15
            adapter = fragmentManager?.let {
                CardPagerAdapter(
                    it,
                    cardsList as MutableList<Card>
                )
            }
        }

        viewModel.dispatchViewAction(HomeViewAction.RetrieveExpensesCard)
    }

    private fun setupExpenses(expensesList: List<Expense>) {
        binding.extractHistory.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = ExtractExpenseAdapter(
                expensesList as ArrayList<Expense>
            )
        }
    }
}