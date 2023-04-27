package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.FragmentCardBinding
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.adapter.CardPageAdapter
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel.CardFragmentViewModel


class Card : Fragment() {
   private lateinit var binding: FragmentCardBinding
   private lateinit var adapter : CardFragmentViewModel
    private val viewModel : CardFragmentViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_card, container, false)

//
//        adapter = CardPageAdapter(requireContext(),viewModel.cardItem)
        binding.cardObject = this
//        binding.rcCard.adapter =
        return binding.root
    }


}