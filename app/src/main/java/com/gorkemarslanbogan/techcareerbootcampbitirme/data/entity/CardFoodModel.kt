package com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CardFoodModel(var sepet_yemekler: List<CardFood>,  var success: Int)

data class CardFood(val sepet_yemek_id: Int,
                    val yemek_adi : String,
                    val yemek_resim_adi: String,
                    var yemek_fiyat: Int,
                    var yemek_siparis_adet: Int,
                    val kullanici_adi: String) : Serializable
