package com.example.expenses.expenses.tracking.model.card

import android.os.Parcelable

abstract class Card(
    val cardNumber: String?,
    val resume: String?,
    val incomeResume: String?,
    val outcomeResume: String?
) : Parcelable {

    fun isValuesNull(): Boolean {
        val listToValidate = listOf(
            cardNumber.isNullOrEmpty(),
            resume.isNullOrEmpty()
        )

        listToValidate.forEach {
            if (it) {
                return true
            }
        }

        return false
    }
}