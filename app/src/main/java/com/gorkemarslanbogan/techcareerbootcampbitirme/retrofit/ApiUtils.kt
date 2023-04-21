package com.gorkemarslanbogan.techcareerbootcampbitirme.retrofit

class ApiUtils {

    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/yemekler/"
        fun getRequest(): ApiRequests {
            return RetrofitClient.getClient(BASE_URL).create(ApiRequests::class.java)
        }
    }

}