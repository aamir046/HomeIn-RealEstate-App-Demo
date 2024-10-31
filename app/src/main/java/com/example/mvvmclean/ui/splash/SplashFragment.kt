package com.example.mvvmclean.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mvvmclean.BR
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseFragment
import com.example.mvvmclean.base.NavigationCommand
import com.example.mvvmclean.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashVM>(){

    private val mainViewModel: SplashVM by viewModels()

    override val bindingVariable: Int = BR.viewModel

    override val layoutId: Int = R.layout.fragment_splash

    override val viewModel: SplashVM by lazy { mainViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToTargetScreen()
        }, 4000)
    }

    private fun navigateToTargetScreen(){
        navigate(NavigationCommand.To(SplashFragmentDirections.toIntroFragment()))
    }

}