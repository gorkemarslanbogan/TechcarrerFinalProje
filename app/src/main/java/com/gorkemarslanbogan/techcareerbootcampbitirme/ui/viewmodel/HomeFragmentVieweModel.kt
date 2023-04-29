package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Foods
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.repo.FoodRequestRepository

class HomeFragmentVieweModel : ViewModel() {
    private val foodRepo = FoodRequestRepository()
    var foodItem: MutableLiveData<List<Foods>>

    init {
        getData()
        foodItem = foodRepo.getFood()
    }


    fun getData(){
       foodRepo.fetchAllFood(0)
       //foodRepo.fetchAllFood(1)
    }

    fun addToCard(food: Foods, stock: Int, context:Context) {
        if(foodRepo.isHaveFoodStock(food,stock)){
            Toast.makeText(context, "Ürün Sepete Eklendi..", Toast.LENGTH_SHORT).show()
        }else {
            foodRepo.addToCard(food,stock,context)
        }
    }

    fun getFoodImages(view: ImageView, imageName: String){
       foodRepo.getFoodImages(view,imageName)
    }

}