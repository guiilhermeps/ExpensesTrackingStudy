package com.example.expenses.expenses.tracking.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}

class ExtractExpenseHolder(
    private val binding: ItemExpenseDescriptionBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindExpense(listemItem: Expense) = with(binding) {

    }
}