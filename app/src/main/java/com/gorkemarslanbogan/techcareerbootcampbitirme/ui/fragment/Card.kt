package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.FragmentCardBinding
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.adapter.CardPageAdapter
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel.CardFragmentViewModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel.DetailsFragmentVieweModel


class Card : Fragment() {
   private lateinit var binding: FragmentCardBinding
   private val viewModel : CardFragmentViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_card, container, false)

        viewModel.cardItem.observe(viewLifecycleOwner){
            val adapter  = CardPageAdapter(requireContext(),it,viewModel)
            binding.rcCard.adapter = adapter
        }
        binding.cardObject = this
        binding.backButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.go_to_home)
        }
        return binding.root
    }


}