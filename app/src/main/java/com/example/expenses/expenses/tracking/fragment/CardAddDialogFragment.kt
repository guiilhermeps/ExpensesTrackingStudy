package com.example.expenses.expenses.tracking.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.expenses.expenses.tracking.databinding.DialogAddCardBinding
import com.example.expenses.expenses.tracking.model.CardInfo
import com.example.expenses.expenses.tracking.util.CardHolder

class CardAddDialogFragment(
    private val notifyOnChanged : () -> Unit
) : DialogFragment() {
    private lateinit var bindingAddCardDialog: DialogAddCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingAddCardDialog = DialogAddCardBinding.inflate(inflater, container, false)

        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }

        return bindingAddCardDialog.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupButtons()
        setupEditText()
    }

    private fun setupButtons() {
        bindingAddCardDialog.apply {
            addButton.setOnClickListener {
                CardHolder.cardList.add(
                    CardInfo(
                        cardNumber = cardNumber.text.toString(),
                        resume = initialBalance.text.toString()
                    )
                )
                notifyOnChanged.invoke()
                dismiss()
            }

            closeButton.setOnClickListener {
                dismiss()
            }
        }
    }

    private fun setupEditText() {
    }
}