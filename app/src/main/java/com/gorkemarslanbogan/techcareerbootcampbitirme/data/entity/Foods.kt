package com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Foods(var yemek_id: String,var yemek_adi : String, var yemek_resim_adi: String,var yemek_fiyat: String) : Serializable
