package com.example.expenses.expenses.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.model.Card
import com.example.expenses.expenses.tracking.databinding.ItemCardInfoBinding

class CardAdapterFragment(private val cardItemInfo: Card) : Fragment() {
    private lateinit var binding: ItemCardInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemCardInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardInfo.text = cardItemInfo.cardNumber
        binding.cardSaldo.text = cardItemInfo.resume
        binding.incomeInfo.text = cardItemInfo.incomeResume
        binding.outcomeInfo.text = cardItemInfo.outcomeResume
    }
}