package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Food
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.FragmentHomePageBinding
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.Adapter.HomePageAdapter

class HomePage : Fragment() {
    lateinit var binding : FragmentHomePageBinding
    private val item  = mutableListOf<Food>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home_page, container, false)

        binding.homePageObject = this
        binding.rcProducts.adapter = HomePageAdapter(requireContext(),item)

        return binding.root

    }
}