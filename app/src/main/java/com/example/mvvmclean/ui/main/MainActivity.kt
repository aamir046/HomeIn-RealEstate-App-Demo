package com.example.mvvmclean.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.example.mvvmclean.BR
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseActivity
import com.example.mvvmclean.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val mainViewModel: MainViewModel by viewModels()

    override val bindingVariable: Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override val layoutId: Int = R.layout.activity_main

    override val viewModel: MainViewModel by lazy { mainViewModel  }
}