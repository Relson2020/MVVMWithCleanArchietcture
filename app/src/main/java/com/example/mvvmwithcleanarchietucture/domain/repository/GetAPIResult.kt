package com.example.mvvmwithcleanarchietucture.domain.repository

import com.example.mvvmwithcleanarchietucture.domain.model.MyDataItem

interface GetAPIResult {

    suspend fun getData() : List<MyDataItem>
}