package com.example.expenses.expenses.tracking.model

import android.os.Parcel
import android.os.Parcelable
import com.example.expenses.expenses.tracking.CardInterface

class Card(
    cardNumber: String?,
    resume: String?,
    incomeResume: String?,
    outcomeResume: String?
) : CardInterface(cardNumber, resume, incomeResume, outcomeResume) {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cardNumber)
        parcel.writeString(resume)
        parcel.writeString(incomeResume)
        parcel.writeString(outcomeResume)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Card> {
        override fun createFromParcel(parcel: Parcel): Card {
            return Card(parcel)
        }

        override fun newArray(size: Int): Array<Card?> {
            return arrayOfNulls(size)
        }
    }
}