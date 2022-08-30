package com.example.shoestorerewrite

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestorerewrite.databinding.FragmentShoeListBinding
import com.example.shoestorerewrite.databinding.ShoeEntryBinding
import com.example.shoestorerewrite.models.ShoeViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
       // binding.lifecycleOwner = this
        setHasOptionsMenu(true)
        viewModel.shoesList.observe(viewLifecycleOwner, Observer{ shoeList->
            for(item in shoeList){
                val shoeItem = ShoeEntryBinding.inflate(layoutInflater)
                shoeItem.shoeData = item
                binding.linearShoeList.addView(shoeItem.root)
            }
           binding.addShoeBttn.setOnClickListener{
                findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
            }
        })

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}