package com.example.mvvmwithcleanarchietucture.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmwithcleanarchietucture.data.repository.Repository
import com.example.mvvmwithcleanarchietucture.domain.model.MyDataItem

class GetApiResultUseCase(private val repository: Repository) {

    private var apiResultMutableLiveData: MutableLiveData<List<MyDataItem>> = MutableLiveData()
    val apiResultLiveData: LiveData<List<MyDataItem>>
        get() = apiResultMutableLiveData

    /**
     * Getting the result from Repository getData() function
     * storing the result in apiResultMutableLiveData
     */
    suspend fun getData() {
        val result = repository.getData()
        apiResultMutableLiveData.postValue(result)
    }
}