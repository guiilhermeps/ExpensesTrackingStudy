package com.example.expenses.expenses.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.databinding.ItemCardAddBinding

class AddCardAdapterFragment : Fragment() {
    private lateinit var bindingAddCard: ItemCardAddBinding

    companion object {
        fun newInstance(): Fragment {
            return AddCardAdapterFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingAddCard = ItemCardAddBinding.inflate(inflater, container, false)
        return bindingAddCard.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddCard()
    }

    private fun setAddCard() {
        bindingAddCard.addCard.setOnClickListener {
            Toast.makeText(context, "Adicionei um Card Uhul", Toast.LENGTH_LONG).show()
        }
    }
}