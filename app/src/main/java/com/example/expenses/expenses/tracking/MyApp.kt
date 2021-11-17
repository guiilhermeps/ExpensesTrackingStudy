package com.example.expenses.expenses.tracking

import android.app.Application
import com.example.expenses.expenses.tracking.model.card.Card
import com.example.expenses.expenses.tracking.model.card.CardInfo
import com.example.expenses.expenses.tracking.model.card.EmptyCard
import com.example.expenses.expenses.tracking.model.expenses.Expense
import java.util.*

class MyApp : Application() {

    val cardHolder = mutableListOf<Card>()
    val expenseHolder = mutableListOf<Expense>()

    override fun onCreate() {
        super.onCreate()

        cardHolder.apply {
            add(
                CardInfo(
                    "4891 9858 9875 4894",
                    "R$ 1.545,00",
                    "R$ 125,00",
                    "R$ 125,00"
                )
            )

            add(EmptyCard())
        }

        expenseHolder.apply {
            add(
                Expense(
                    1,
                    Date(),
                    "Mensalidade Condominio",
                    "Moradia",
                    false,
                    545.75
                )
            )
            add(
                Expense(
                    1,
                    Date(),
                    "Pix venda Video Game",
                    "Venda",
                    true,
                    2500.00
                )
            )
        }
    }
}