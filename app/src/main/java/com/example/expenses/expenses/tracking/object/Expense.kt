package com.example.expenses.expenses.tracking.`object`

import java.util.*

data class Expense(
    val expenseShowType: Int,
    val expenseDate: Date,
    val expenseName: String,
    val expenseTypeCategory: String,
    val isIncomeValue: Boolean,
    val expenseValue: Double
)