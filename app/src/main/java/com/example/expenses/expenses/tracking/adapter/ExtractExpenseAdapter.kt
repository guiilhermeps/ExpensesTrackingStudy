package com.example.expenses.expenses.tracking.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.model.Expense

class ExtractExpenseAdapter(
    private val extractExpenseList: ArrayList<Expense>
) : RecyclerView.Adapter<ExtractExpenseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ExtractExpenseHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card_expense_descript, parent, false)
        )

    override fun onBindViewHolder(holder: ExtractExpenseHolder, position: Int) {
        holder.bindExpanse(extractExpenseList[position])
    }

    override fun getItemCount() = extractExpenseList.size
}

class ExtractExpenseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val expenseTitle = itemView.findViewById<TextView>(R.id.expense_name)
    private val expenseCategory = itemView.findViewById<TextView>(R.id.expense_category)
    private val expenseIcon = itemView.findViewById<ImageView>(R.id.expense_type_icon)
    private val expenseVal = itemView.findViewById<TextView>(R.id.expense_value)

    fun bindExpanse(listItem: Expense) {
        listItem.run {
            expenseTitle.text = expenseName
            expenseCategory.text = expenseTypeCategory

            expenseIcon.setIconForExpense(isIncomeValue)
            expenseVal.setExpenseTextColor(isIncomeValue, expenseValue)
        }
    }

    private fun ImageView.setIconForExpense(isIncomingValue: Boolean) {
        if (isIncomingValue) {
            setImageDrawable(
                itemView.resources.getDrawable(R.drawable.ic_income_arrow, itemView.context.theme)
            )
        } else {
            setImageDrawable(
                itemView.resources.getDrawable(R.drawable.ic_outcome_arrow, itemView.context.theme)
            )
        }
    }

    private fun TextView.setExpenseTextColor(isComingValue: Boolean, expenseValue: Double) {
        if (isComingValue) {
            apply {
                text = "+R$ $expenseValue ".replace(".", ",")
                setTextColor(resources.getColor(R.color.green))
            }
        } else {
            apply {
                text = "-R$ $expenseValue".replace(".", ",")
                setTextColor(resources.getColor(R.color.red))
            }
        }
    }
}