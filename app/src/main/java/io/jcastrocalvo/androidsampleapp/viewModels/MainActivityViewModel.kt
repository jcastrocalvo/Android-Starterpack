package io.jcastrocalvo.androidsampleapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    var inputText = MutableLiveData<String>()
    var showInput = MutableLiveData<Boolean>()

    init {
        showInput.postValue(true)
    }
    fun toggleShowInput() {
        showInput.postValue(!showInput.value!!)
    }
}