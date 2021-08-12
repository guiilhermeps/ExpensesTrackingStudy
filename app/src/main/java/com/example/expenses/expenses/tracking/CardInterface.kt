package com.example.expenses.expenses.tracking

import android.os.Parcelable

abstract class CardInterface(
    val cardNumber: String?,
    val resume: String?,
    val incomeResume: String?,
    val outcomeResume: String?
) : Parcelable {

    fun isValuesNull(): Boolean {
        val listToValidate = listOf(
            cardNumber.isNullOrEmpty(),
            resume.isNullOrEmpty(),
            incomeResume.isNullOrEmpty(),
            outcomeResume.isNullOrBlank()
        )

        listToValidate.forEach {
            if (it) {
                return true
            }
        }

        return false
    }
}