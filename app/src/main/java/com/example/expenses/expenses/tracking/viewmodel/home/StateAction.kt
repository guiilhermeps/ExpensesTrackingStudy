package com.example.expenses.expenses.tracking.viewmodel.home

import com.example.expenses.expenses.tracking.model.card.Card
import com.example.expenses.expenses.tracking.model.expenses.Expense

sealed class HomeViewState {
    object Loading : HomeViewState()
    object Error : HomeViewState()
    data class CardsLoaded(val cardList: List<Card>?) : HomeViewState()
    data class ExpensesLoaded(val expensesList: List<Expense>?) : HomeViewState()
}

sealed class HomeViewAction {
    object RetrieveSavedCards : HomeViewAction()
    object RetrieveExpensesCard : HomeViewAction()
    object AlterTheme : HomeViewAction()
}