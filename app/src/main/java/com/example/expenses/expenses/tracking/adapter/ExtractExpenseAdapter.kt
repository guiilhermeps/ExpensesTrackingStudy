package com.example.expenses.expenses.tracking.adapter

import android.graphics.Color.green
import android.graphics.Color.red
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.expenses.expenses.tracking.R
import com.example.expenses.expenses.tracking.`object`.Expense
import com.example.expenses.expenses.tracking.databinding.ItemExpenseDescriptionBinding

class ExtractExpenseAdapter(
    private val extractExpenseList: ArrayList<Expense>
) : RecyclerView.Adapter<ExtractExpenseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtractExpenseHolder {
        val binding = ItemExpenseDescriptionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExtractExpenseHolder(binding)
    }

    override fun onBindViewHolder(holder: ExtractExpenseHolder, position: Int) {
        holder.bindExpense(extractExpenseList[position])
    }

    override fun getItemCount() = extractExpenseList.size
}

class ExtractExpenseHolder(
    private val binding: ItemExpenseDescriptionBinding
) : RecyclerView.ViewHolder(binding.root) {

    private val expenseTitle = binding.expenseName
    private val expenseCategory = binding.expenseCategory
    private val expenseIcon = binding.expenseTypeIcon
    private val expenseVal = binding.expenseValue

    fun bindExpense(listItem: Expense) = with(binding) {
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
                itemView.resources.getDrawable(R.drawable.ic_seta_vermelha, itemView.context.theme)
            )
        } else {
            setImageDrawable(
                itemView.resources.getDrawable(R.drawable.ic_seta_verde, itemView.context.theme)
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