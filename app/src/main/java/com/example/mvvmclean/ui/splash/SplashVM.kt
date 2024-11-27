package com.example.mvvmclean.ui.splash

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.example.mvvmclean.base.BaseViewModel
import com.example.mvvmclean.data.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor (
    private val dataStoreRepository: DataStoreRepository
) : BaseViewModel(){

    var isFirstTimeAppUse = true

    init {
        viewModelScope.launch {
            dataStoreRepository.getIsFirstTimeAppUse.collect { value ->
                isFirstTimeAppUse = value
            }
        }
    }

}