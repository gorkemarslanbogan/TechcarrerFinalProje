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
    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        binding.homeFragmentObject = this
        getAllData()
        binding.customToolbar.title = "Yemek Sepeti"
        (activity as AppCompatActivity).setSupportActionBar(binding.customToolbar)
        return binding.root
    }

    private fun getAllData(){
        ApiUtils.getRequest().getAllFood().enqueue(object : Callback<FoodModel> {
            override fun onResponse(call: Call<FoodModel>, response: Response<FoodModel>) {
                if(response.body()?.yemekler?.isNotEmpty() == true){

                    val adapter = HomePageAdapter(requireContext(),response.body()?.yemekler!!)
                    binding.rcFood.adapter = adapter
                }
            }
            override fun onFailure(call: Call<FoodModel>, t: Throwable) {

            }

        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_bag -> {
            true
        }
        else -> {
            false
        }

    }
}