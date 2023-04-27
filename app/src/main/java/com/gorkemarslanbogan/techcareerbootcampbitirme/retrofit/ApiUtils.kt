package com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit

class ApiUtils {

    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"
        val BASE_URL_IMAGE = "http://kasimadalan.pe.hu/yemekler/resimler/"
        fun getRequest(): ApiRequests {
            return RetrofitClient.getClient(BASE_URL).create(ApiRequests::class.java)
        }
    }

}