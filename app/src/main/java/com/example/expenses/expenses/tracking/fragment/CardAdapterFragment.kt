package com.example.expenses.expenses.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.databinding.ItemCardInfoBinding
import com.example.expenses.expenses.tracking.model.Card

class CardAdapterFragment : Fragment() {
    private lateinit var binding: ItemCardInfoBinding

    companion object {
        const val CARD_ITEM_POSITION = "cardPositionItem"

        fun newInstance(cardItemInfo: Card): Fragment{
            return CardAdapterFragment().apply {
                val bundle = Bundle()
                bundle.putParcelable(CARD_ITEM_POSITION, cardItemInfo)

                arguments = bundle
            }
        }
    }

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

        savedInstanceState?.getParcelable<Card>(CARD_ITEM_POSITION)?.apply {
            binding.cardInfo.text = cardNumber
            binding.cardSaldo.text = resume
            binding.incomeInfo.text = incomeResume
            binding.outcomeInfo.text = outcomeResume
        }
    }
}