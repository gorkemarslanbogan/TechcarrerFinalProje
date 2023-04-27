package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel

import android.content.Context
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.R
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.FoodModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Foods
import com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardFragmentViewModel(): ViewModel() {
    lateinit var cardItem : MutableLiveData<List<Foods>>

    init {
        getData()
    }

    private fun getData(){
        ApiUtils.getRequest().getCard("gorkem_arslanbogan").enqueue(object : Callback<FoodModel> {
            override fun onResponse(call: Call<FoodModel>, response: Response<FoodModel>) {
                if(response.body()?.yemekler?.isNotEmpty() == true){
                    cardItem = MutableLiveData(response.body()!!.yemekler)
                    Log.e("Test", cardItem.value?.size.toString())
                }
            }

            override fun onFailure(call: Call<FoodModel>, t: Throwable) {

            }

        })
    }


}