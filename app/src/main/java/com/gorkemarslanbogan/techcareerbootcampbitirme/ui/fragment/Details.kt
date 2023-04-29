package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.CrudResponse
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Foods
import com.gorkemarslanbogan.techcareerbootcampbitirme.databinding.FragmentDetailsBinding
import com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit.ApiUtils
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel.DetailsFragmentVieweModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel.HomeFragmentVieweModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Details : Fragment() {
    private lateinit var binding : FragmentDetailsBinding
    var stock = 0
    private val viewModel : DetailsFragmentVieweModel by viewModels()
    @SuppressLint("SetTextI18n", "FragmentLiveDataObserve")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false)
         val bundle:DetailsArgs by navArgs()
         val response = bundle.food!!
        getFoodImages(response.yemek_resim_adi)
        binding.foodObject = this
        binding.detailsDescTittle.text = response?.yemek_adi
        binding.detailsProductPrice.text = response?.yemek_fiyat  + " ${requireContext().getString(R.string.turk_lirasi_sembol)}"

        viewModel.stock.observe(this){
            binding.stockSize.setText(it.toString())
            stock = it

        }
        binding.backButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_details_to_HomeFragment)
        }
        binding.button.setOnClickListener {
            addToCard(response, stock)
        }

        return binding.root
    }

    fun addToCard(food: Foods, stock: Int){
        viewModel.addToCard(food,stock,requireContext())
    }

    fun addStock(){
        viewModel.addStock()
    }

    fun removeStock(){
        viewModel.removeStock()
    }
    fun getFoodImages(imageName: String){
        viewModel.getFoodImages(binding.imageView,imageName)
    }

}