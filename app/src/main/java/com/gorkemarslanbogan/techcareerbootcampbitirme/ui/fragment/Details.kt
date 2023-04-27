package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.FragmentDetailsBinding
import com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit.ApiUtils

class Details : Fragment() {
    lateinit var binding : FragmentDetailsBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false)

        val bundle:DetailsArgs by navArgs()
        val response = bundle.food

        binding.foodObject = this
        binding.detailsDescTittle.text = response?.yemek_adi
        binding.detailsProductPrice.text = response?.yemek_fiyat  + " ${requireContext().getString(R.string.turk_lirasi_sembol)}"
        Glide.with(this).load(ApiUtils.BASE_URL_IMAGE+response?.yemek_resim_adi).into(binding.imageView)

        return binding.root
    }


}