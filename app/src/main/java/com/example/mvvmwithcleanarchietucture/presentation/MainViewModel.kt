package com.example.mvvmwithcleanarchietucture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithcleanarchietucture.domain.model.MyDataItem
import com.example.mvvmwithcleanarchietucture.domain.usecase.GetApiResultUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val getApiResultUseCase: GetApiResultUseCase) : ViewModel() {

    /**
     * Calling getData function in GetAPIResult
    */
    fun get(){
        viewModelScope.launch(Dispatchers.IO) {
            getApiResultUseCase.getData()
        }
    }

    val apiResultLiveData : LiveData<List<MyDataItem>>
    get() = getApiResultUseCase.apiResultLiveData
}