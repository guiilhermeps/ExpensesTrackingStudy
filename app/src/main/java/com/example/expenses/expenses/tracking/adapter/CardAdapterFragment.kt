package com.example.expenses.expenses.tracking.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.`object`.Card
import com.example.expenses.expenses.tracking.databinding.FragmentHomeBinding
import com.example.expenses.expenses.tracking.databinding.ItemCardInfoBinding

class CardAdapterFragment(private val cardItemInfo: Card) : Fragment() {
    private lateinit var binding: ItemCardInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemCardInfoBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtCardNumber.text = cardItemInfo.cardNumber
        binding.txtBalanceNumber.text = cardItemInfo.resume
        binding.txtIncomeNumber.text = cardItemInfo.incomeResume
        binding.txtExpensesNumber.text = cardItemInfo.outComeResume
    }
}