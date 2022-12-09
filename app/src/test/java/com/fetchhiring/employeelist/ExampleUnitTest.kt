package com.fetchhiring.employeelist

import com.fetchhiring.employeelist.network.ApiService
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiServiceTest {
    @Test
    fun testValidInterface() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create()) // Will throw an exception if interface is not valid
            .build()
        retrofit.create(ApiService::class.java)
    }
}