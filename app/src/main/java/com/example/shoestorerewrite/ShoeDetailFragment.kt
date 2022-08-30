package com.example.shoestorerewrite

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestorerewrite.databinding.FragmentShoeDetailBinding
import com.example.shoestorerewrite.models.ShoeViewModel
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.shoeSaveBttn.setOnClickListener {
            viewModel.saveShoe(binding.shoeNameEdit.text.toString(),binding.shoeSizeEdit.text.toString().toDouble(),binding.shoeBrandEdit.text.toString(),binding.shoeDescEdit.text.toString())
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
        binding.shoeCancelBttn.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
        return binding.root
    }
}