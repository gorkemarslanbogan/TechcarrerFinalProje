package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.CardFood
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.FoodModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Foods
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.repo.FoodRequestRepository
import com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardFragmentViewModel(): ViewModel() {
    val foodRepo = FoodRequestRepository()
    var cardItem: MutableLiveData<List<CardFood>>

    init {
        getData()
        cardItem = foodRepo.getCard()
    }


    private fun getData(){
        foodRepo.fetchAllFood(1)
    }

    fun removeCard(food_id: Int) {
        return foodRepo.deletecardItem(food_id)
    }

    fun getFoodImages(view: ImageView, imageName: String){
        foodRepo.getFoodImages(view,imageName)
    }

}