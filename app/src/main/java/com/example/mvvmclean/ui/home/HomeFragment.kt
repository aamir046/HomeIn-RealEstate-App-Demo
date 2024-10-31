package com.example.mvvmclean.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mvvmclean.BR
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseFragment
import com.example.mvvmclean.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeVM>(){

    private val homeViewModel: HomeVM by viewModels()

    override val bindingVariable: Int = BR.viewModel

    override val layoutId: Int = R.layout.fragment_home

    override val viewModel: HomeVM by lazy { homeViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}