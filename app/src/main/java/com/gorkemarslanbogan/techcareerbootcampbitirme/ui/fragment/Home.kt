package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.FragmentHomeBinding


class Home : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)

        binding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.go_to_details)
        }
        return binding.root
    }

}