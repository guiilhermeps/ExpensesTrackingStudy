package com.example.expenses.expenses.tracking.viewmodel.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.expenses.expenses.tracking.MyApp

class HomeViewModel(
    private val application: Application
) : ViewModel() {

    private val _viewState = MutableLiveData<HomeViewState>()
    val viewState: LiveData<HomeViewState> = _viewState

    private val _viewAction = MutableLiveData<HomeViewAction>()
    val viewAction: LiveData<HomeViewAction> = _viewAction

    fun dispatchViewAction(viewAction: HomeViewAction) {
        when (viewAction) {
            is HomeViewAction.RetrieveExpensesCard -> getSavedExpenses()
            is HomeViewAction.RetrieveSavedCards -> getSavedCards()
            is HomeViewAction.AlterTheme -> {
            }
        }
    }

    private fun getSavedCards() {
        _viewState.value = HomeViewState.CardsLoaded((application as MyApp).cardHolder)
    }

    private fun getSavedExpenses() {
        _viewState.value = HomeViewState.ExpensesLoaded((application as MyApp).expenseHolder)
    }

    private fun notifyToChangeAppTheme() {}
}