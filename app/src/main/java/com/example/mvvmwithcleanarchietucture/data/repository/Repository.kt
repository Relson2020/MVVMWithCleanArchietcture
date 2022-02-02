package com.example.mvvmwithcleanarchietucture.data.repository

import com.example.mvvmwithcleanarchietucture.data.source.ApiInterface
import com.example.mvvmwithcleanarchietucture.domain.model.MyDataItem
import com.example.mvvmwithcleanarchietucture.domain.repository.GetAPIResult

// Repository Class
class Repository(private val apiInterface: ApiInterface) : GetAPIResult {

    /**
     * Get the data from the API
     *
     * @return Return the result list
    */
    override suspend fun getData(): List<MyDataItem> {
        return apiInterface.getData()
    }
}