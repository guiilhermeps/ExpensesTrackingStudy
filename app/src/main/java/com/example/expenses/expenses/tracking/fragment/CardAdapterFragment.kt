package com.example.expenses.expenses.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.`object`.Card
import com.example.expenses.expenses.tracking.databinding.CardInfoBinding

class CardAdapterFragment(private val cardInfo: Card): Fragment() {
    private lateinit var binding: CardInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CardInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardNumber.text = cardInfo.cardNumber
        binding.balanceValue.text = cardInfo.resume
        binding.entryValue.text = cardInfo.incomeResume
        binding.expenseValue.text = cardInfo.outcomeResume
    }
}