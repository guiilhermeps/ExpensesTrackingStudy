package com.example.expenses.expenses.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.model.Card
import com.example.expenses.expenses.tracking.databinding.CardInfoBinding

class CardAdapterFragment() : Fragment() {
    private lateinit var binding: CardInfoBinding

    companion object {
        const val CARD_ITEM_POSITION = "cardPositionItem"

        fun newInstance(cardInfo: Card): Fragment {
            return CardAdapterFragment().apply {
                val bundle = Bundle()
                bundle.putParcelable(CARD_ITEM_POSITION, cardInfo)
                arguments = bundle
            }
        }
    }

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

        savedInstanceState?.getParcelable<Card>(CARD_ITEM_POSITION)?.apply {

            binding.cardNumber.text = cardNumber
            binding.balanceValue.text = resume
            binding.entryValue.text = incomeResume
            binding.expenseValue.text = outcomeResume
        }
    }
}