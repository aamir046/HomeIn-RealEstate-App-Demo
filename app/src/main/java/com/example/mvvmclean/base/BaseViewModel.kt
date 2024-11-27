package com.example.mvvmclean.base

import androidx.lifecycle.ViewModel
import com.example.mvvmclean.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val isLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val showToast: SingleLiveEvent<String> = SingleLiveEvent()
}

