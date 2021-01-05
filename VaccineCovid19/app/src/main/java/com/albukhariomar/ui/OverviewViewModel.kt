package com.albukhariomar.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response : LiveData<String>
        get() = _response


    init {

    }

    private fun getFromApi () {
        _response.value = "YO, I AM HERE!"
    }



}