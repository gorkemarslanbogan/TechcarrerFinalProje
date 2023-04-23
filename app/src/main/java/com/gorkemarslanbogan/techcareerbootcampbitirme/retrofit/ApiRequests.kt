package com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit

import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.CrudResponse
import com.gorkemarslanbogan.techcareerbootcampbitirme.data.entity.Food
import retrofit2.Call
import retrofit2.http.*

interface ApiRequests {

    @GET("tumYemekleriGetir.php")
    @FormUrlEncoded
    fun getAllFood() : Call<List<Food>>

    @POST("sepeteYemekEkle.php")
    @FormUrlEncoded
    fun addToCard(
        @Field("yemek_adi")
        yemek_adi: String,
        @Field("yemek_resim_adi")
        yemek_resim_adi: String,
        @Field("yemek_fiyat")
        yemek_fiyat: Int,
        @Field("yemek_siparis_adet")
        yemek_siparis_adet: Int,
        @Field("kullanici_adi")
        kullanici_adi: String) : Call<CrudResponse>

    @POST("sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun getCard(@Field("kullanici_adi")
                kullanici_adi: String) : Call<Food>

    @POST("sepettenYemekSil.php")
    @FormUrlEncoded
    fun deleteCard(@Field("sepet_yemek_id")
                   sepet_yemek_id: Int,
                   @Field("kullanici_adi")
                   kullanici_adi: String) : Call<CrudResponse>

}