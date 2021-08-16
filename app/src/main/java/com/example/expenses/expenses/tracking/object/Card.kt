package com.example.expenses.expenses.tracking.`object`

import android.os.Parcel
import android.os.Parcelable

abstract class Card(
    val cardNumber: String?,
    val resume: String?,
    val incomeResume: String?,
    val outComeResume: String?,
) : Parcelable {

    fun isValuesNull(): Boolean {
        val listToValidate = listOf(
            cardNumber.isNullOrEmpty(),
            resume.isNullOrEmpty(),
            incomeResume.isNullOrEmpty(),
            outComeResume.isNullOrEmpty()
        )

        listToValidate.forEach {
            if (it) {
                return false
            }
        }
        return false
    }
}