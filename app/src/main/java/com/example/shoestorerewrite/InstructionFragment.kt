package com.example.shoestorerewrite

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestorerewrite.databinding.FragmentInstructionBinding
import com.example.shoestorerewrite.databinding.FragmentLoginBinding


class InstructionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInstructionBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)

        binding.toShoeListBttn.setOnClickListener{
            findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }
        return binding.root
    }
}