package com.example.expenses.expenses.tracking.model

import android.os.Parcel
import android.os.Parcelable
import com.example.expenses.expenses.tracking.Card

class EmptyCard : Card(null, null, null, null) {

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cardNumber)
        parcel.writeString(resume)
        parcel.writeString(incomeResume)
        parcel.writeString(outcomeResume)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmptyCard> {
        override fun createFromParcel(parcel: Parcel): EmptyCard {
            return EmptyCard()
        }

        override fun newArray(size: Int): Array<EmptyCard?> {
            return arrayOfNulls(size)
        }
    }
}