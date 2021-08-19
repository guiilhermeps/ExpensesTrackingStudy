package com.example.expenses.expenses.tracking.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.expenses.expenses.tracking.databinding.DialogAddCardBinding

class CardAddDialogFragment : DialogFragment() {
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
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindingAddCardDialog.apply {
            addButton.setOnClickListener {
                Toast.makeText(requireContext(), "Adicionando Cartão..", Toast.LENGTH_LONG).show()
            }

            closeButton.setOnClickListener {
                dismiss()
            }
        }
    }
}