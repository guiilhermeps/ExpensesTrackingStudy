package com.example.expenses.expenses.tracking.model

import android.os.Parcel
import android.os.Parcelable

data class Card(
    val cardNumber: String?,
    val resume: String?,
    val incomeResume: String?,
    val outcomeResume: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

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