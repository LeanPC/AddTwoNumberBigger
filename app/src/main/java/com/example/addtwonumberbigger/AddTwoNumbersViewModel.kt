package com.example.addtwonumberbigger

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddTwoNumbersViewModel: ViewModel() {
    private var result : MutableLiveData<String> = MutableLiveData()

    fun getResult():LiveData<String>{
        return result
    }

    fun sum(numberLeft: String, numberRight: String){
        result.value = AddTwoNumbersUseCase().sum(numberLeft,numberRight)
    }
}