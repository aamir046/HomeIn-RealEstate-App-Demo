package com.example.mvvmclean.ui.splash

import androidx.lifecycle.asLiveData
import com.example.mvvmclean.base.BaseViewModel
import com.example.mvvmclean.data.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor (
     val dataStoreRepository: DataStoreRepository
) : BaseViewModel(){

    val isFirstTimeLogin:Boolean = dataStoreRepository.getIsFirstTimeAppUse.asLiveData().value ?: false

}