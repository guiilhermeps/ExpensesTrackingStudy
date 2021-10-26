package com.example.expenses.expenses.tracking.model

import android.os.Parcel
import android.os.Parcelable
import com.example.expenses.expenses.tracking.Card

class CardInfo(
    cardNumber: String?,
    resume: String?,
    incomeResume: String? = "",
    outcomeResume: String? = ""
) : Card(cardNumber, resume, incomeResume, outcomeResume) {

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

    companion object CREATOR : Parcelable.Creator<CardInfo> {
        override fun createFromParcel(parcel: Parcel): CardInfo {
            return CardInfo(parcel)
        }

        override fun newArray(size: Int): Array<CardInfo?> {
            return arrayOfNulls(size)
        }
    }
}