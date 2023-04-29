package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationBarMenu
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.FoodModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.FragmentHomeBinding
import com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit.ApiUtils
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.adapter.HomePageAdapter
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel.HomeFragmentVieweModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Home : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val viewModel : HomeFragmentVieweModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        binding.homeFragmentObject = this
        viewModel.foodItem.observe(viewLifecycleOwner){
            val adapter = HomePageAdapter(requireContext(),it,viewModel)
            binding.rcFood.adapter = adapter
        }

        binding.cardButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.go_to_card)
        }
        return binding.root
    }
    
}