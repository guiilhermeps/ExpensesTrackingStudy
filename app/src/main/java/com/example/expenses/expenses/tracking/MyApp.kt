package com.example.expenses.expenses.tracking

import android.app.Application
import com.example.expenses.expenses.tracking.model.card.Card
import com.example.expenses.expenses.tracking.model.card.CardInfo
import com.example.expenses.expenses.tracking.model.card.EmptyCard

class MyApp : Application() {

    val cardHolder = mutableListOf<Card>()

    override fun onCreate() {
        super.onCreate()

        cardHolder.add(
            CardInfo(
                "4891 9858 9875 4894",
                "R$ 1.545,00",
                "R$ 125,00",
                "R$ 125,00"
            )
        )

        cardHolder.add(EmptyCard())
    }
}