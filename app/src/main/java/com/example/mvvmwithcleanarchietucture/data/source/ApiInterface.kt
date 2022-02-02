package com.example.mvvmwithcleanarchietucture.data.source

import com.example.mvvmwithcleanarchietucture.domain.model.MyDataItem
import retrofit2.http.*

interface ApiInterface {

    @GET("posts")
    suspend fun getData() : List<MyDataItem>

}