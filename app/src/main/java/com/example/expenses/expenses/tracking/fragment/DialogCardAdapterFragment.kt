package com.example.expenses.expenses.tracking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.expenses.expenses.tracking.databinding.DialogAddCardBinding

class DialogCardAdapterFragment : Fragment() {
    private lateinit var bindingDialog: DialogAddCardBinding

    companion object {
        fun newInstance(): Fragment {
            return DialogCardAdapterFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingDialog = DialogAddCardBinding.inflate(inflater,container,false)
        return bindingDialog.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setBtnAdd()
        closeDialog()
    }

    private fun setBtnAdd() {
        bindingDialog.btnAddCard.setOnClickListener{
            Toast.makeText(context,"Adicionei o cartao",Toast.LENGTH_LONG).show()
        }
    }

    private fun closeDialog(){
        bindingDialog.closeDialog.setOnClickListener{
            Toast.makeText(context,"fechei o dialog",Toast.LENGTH_LONG).show()
        }
    }
}