package com.fetchhiring.employeelist.network

import com.fetchhiring.employeelist.models.Employee
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")
    suspend fun getEmployees(): List<Employee>

    //get an instance of the API Service
    // companion object can be called without having the instance of the class
    companion object {
        private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
        private var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}