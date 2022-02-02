package com.example.mvvmwithcleanarchietucture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithcleanarchietucture.domain.usecase.GetApiResultUseCase

class MainViewModelFactory(private val getApiResultUseCase: GetApiResultUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getApiResultUseCase) as T
    }
}