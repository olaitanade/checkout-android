package com.tayo.checkoutsample.ui.ticket

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.tayo.checkoutsample.R
import com.tayo.checkoutsample.databinding.TicketFragmentBinding
import com.tayo.checkoutsample.ui.ItemRecyclerViewAdapter
import com.tayo.checkoutsample.ui.MainActivityViewModel
import com.tayo.checkoutsample.util.Helper.formatAmount
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TicketFragment : Fragment() {

    private var _binding: TicketFragmentBinding? = null
    private val binding get() = _binding!!

    private val itemsRecyclerViewAdapter: ItemRecyclerViewAdapter by lazy {
        ItemRecyclerViewAdapter(onClickListener = { item ->
            //on item clicked
        })
    }
    private val activityViewModel: MainActivityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TicketFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.checkoutRV.apply {
            adapter = itemsRecyclerViewAdapter
        }
        activityViewModel.itemsModel.observe(viewLifecycleOwner) {
            itemsRecyclerViewAdapter.addData(it.items)
            binding.subtotal.text = "Subtotal: $${formatAmount(it.subTotal)}"
        }
        activityViewModel.getCart()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}