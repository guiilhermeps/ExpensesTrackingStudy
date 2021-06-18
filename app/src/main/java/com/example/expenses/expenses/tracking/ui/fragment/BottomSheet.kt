package com.example.expenses.expenses.tracking.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.expenses.expenses.tracking.databinding.BottomSheetDiologBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDiologBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetDiologBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }
}