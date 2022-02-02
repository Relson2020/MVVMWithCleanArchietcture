package com.example.mvvmwithcleanarchietucture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithcleanarchietucture.presentation.MainViewModel
import com.example.mvvmwithcleanarchietucture.presentation.MainViewModelFactory
import com.example.mvvmwithcleanarchietucture.data.repository.Repository
import com.example.mvvmwithcleanarchietucture.data.source.RetrofitBuilder
import com.example.mvvmwithcleanarchietucture.databinding.ActivityMainBinding
import com.example.mvvmwithcleanarchietucture.domain.usecase.GetApiResultUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var textView = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DataBinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val apiInterface = RetrofitBuilder.retrofitInstance
        val repositoryInstance = Repository(apiInterface)
        val getApiResultUseCase = GetApiResultUseCase(repositoryInstance)

        val viewModel =
            ViewModelProvider(
                this,
                MainViewModelFactory(getApiResultUseCase)
            )[MainViewModel::class.java]

        // Observing apiLiveData from the MainViewModel
        viewModel.apiResultLiveData.observe(this) {
            it.forEach { result ->
                textView += "${result.body}\n\n"
                binding.apiData = textView
            }
        }

        // Clicked listener on the get button
        binding.getButton.setOnClickListener {
            viewModel.get()
        }
    }
}