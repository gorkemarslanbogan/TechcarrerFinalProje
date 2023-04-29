package com.gorkemarslanbogan.techcareerbootcampbitirme.ui.viewmodel

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Foods
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.repo.FoodRequestRepository

class DetailsFragmentVieweModel : ViewModel() {
    private val foodRepo = FoodRequestRepository()
    var stock = MutableLiveData(1)

    fun addStock(){
        this.stock.value = stock.value?.plus(1)
        //foodRepo.fetchAllFood(1)
    }
    fun removeStock(){
        if(stock.value != null){
            if(stock.value != 0 && stock.value!! > 0){
                this.stock.value = stock.value?.minus(1)
            }
        }
    }

    fun addToCard(food: Foods, stock: Int, context: Context)  {
        if(stock>0){
            if(foodRepo.isHaveFoodStock(food,stock)){
                Toast.makeText(context, "Ürün Sepete Eklendi..", Toast.LENGTH_SHORT).show()
            }else {
                foodRepo.addToCard(food,stock,context)
            }
        }
    }

    fun getFoodImages(view: ImageView, imageName: String){
       foodRepo.getFoodImages(view,imageName)
    }

}