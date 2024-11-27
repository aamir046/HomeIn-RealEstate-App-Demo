package com.example.mvvmclean.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.mvvmclean.base.BaseViewModel

class MainViewModel : BaseViewModel(){
    val toolbarTitle: MutableLiveData<String> = MutableLiveData("Explore")
}