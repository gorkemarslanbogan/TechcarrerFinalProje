package com.gorkemarslanbogan.techcareerbootcampbitirme.data.repo

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.*
import com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit.ApiRequests
import com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodRequestRepository{

    var foodsItem: MutableLiveData<List<Foods>> = MutableLiveData()
    var cardItems = MutableLiveData<List<CardFood>>()
    var foodDao:ApiRequests = ApiUtils.getRequest()
    private val user_name = "gorkem_arslanbogan"

    fun getFood() : MutableLiveData<List<Foods>> {
        return foodsItem
    }

    fun getCard() : MutableLiveData<List<CardFood>> {
        return cardItems
    }

    fun isHaveFoodStock(cardFoods: Foods, stock: Int) : Boolean {
        var isAlready = false
        if(cardItems.value?.isNotEmpty() == true){
            val value = cardItems.value
            for (i in value?.indices!!) {
                if(value[i].yemek_adi == cardFoods.yemek_adi && !isAlready){
                    deletecardItem(cardItems.value!![i].sepet_yemek_id)
                    addToCard(cardFoods,cardItems.value!![i].yemek_siparis_adet + stock, null);
                    isAlready = true
                    fetchAllFood(1)
                    break
                }
            }
        }
        return isAlready
    }

    fun fetchAllFood(flag: Int) {
        if(flag == 0){
            foodDao.getAllFood().enqueue(object: Callback<FoodModel>{
                override fun onResponse(call: Call<FoodModel>, response: Response<FoodModel>) {
                    if(response.isSuccessful){
                        val data = response.body()!!.yemekler
                        if(data.isNotEmpty()){
                            foodsItem.value = data
                        }
                    }
                }

                override fun onFailure(call: Call<FoodModel>, t: Throwable) {
                    t.printStackTrace()
                }

            })
        }else if(flag == 1){
            foodDao.getCard(user_name).enqueue(object: Callback<CardFoodModel> {
                override fun onResponse(
                    call: Call<CardFoodModel>,
                    response: Response<CardFoodModel>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()!!.sepet_yemekler
                        if (data.isNotEmpty()) {
                            cardItems.value = data
                        }
                    }
                }
                override fun onFailure(call: Call<CardFoodModel>, t: Throwable) {
                    t.printStackTrace()
                }

            })
        }
    }

    fun addToCard(food: Foods, stock:Int,context: Context?) : Int {
        var value = 0
        ApiUtils.getRequest().addToCard(food.yemek_adi, food.yemek_resim_adi, food.yemek_fiyat.toInt(), stock, user_name).
        enqueue(object : Callback<CrudResponse>{
            override fun onResponse(call: Call<CrudResponse>, response: Response<CrudResponse>) {
                if(response.isSuccessful){
                    value = response.body()!!.success
                    fetchAllFood(1)
                    if(context != null)
                    Toast.makeText(context, "Ürün Sepete Eklendi..", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<CrudResponse>, t: Throwable) {

            }

        })

        return value
    }

    fun deletecardItem(food_id: Int) {
        foodDao.deleteCard(food_id,user_name).enqueue(object: Callback<CrudResponse>{
            override fun onResponse(call: Call<CrudResponse>, response: Response<CrudResponse>) {
                    if(response.isSuccessful){
                            fetchAllFood(1)
                    }
            }

            override fun onFailure(call: Call<CrudResponse>, t: Throwable) {
                t.printStackTrace()
            }

        } )
    }


    fun getFoodImages(view: ImageView, imageName: String){
        Glide.with(view).load(ApiUtils.BASE_URL_IMAGE.plus(imageName)).into(view)
    }

}

