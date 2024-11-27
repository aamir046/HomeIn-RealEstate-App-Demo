package com.example.mvvmclean.ui.intro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvmclean.BR
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseFragment
import com.example.mvvmclean.base.NavigationCommand
import com.example.mvvmclean.databinding.FragmentIntroBinding
import com.example.mvvmclean.ui.splash.SplashFragmentDirections
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroFragment : BaseFragment<FragmentIntroBinding, IntroVM>() {

    private lateinit var viewPager: ViewPager2

    private val introViewModel: IntroVM by viewModels()

    override val bindingVariable: Int = BR.viewModel

    override val layoutId: Int = R.layout.fragment_intro

    override val viewModel: IntroVM by lazy { introViewModel }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewPager()
        setObservables()
    }

    private fun setObservables() {
        setViewPagerChangeCallBack()
        setViewpagerItemChangeObserver()
        setNavigateToMainScreenObserver()
    }

    private fun setNavigateToMainScreenObserver() {
        viewModel.navigateToMainScreen.observe(viewLifecycleOwner) {
            if (it) {
                navigateToHomeScreen()
            }
        }
    }

    private fun setViewpagerItemChangeObserver() {
        viewModel.currentPage.observe(viewLifecycleOwner) { page ->
            if (viewPager.currentItem != page) {
                viewPager.currentItem = page
            }
        }
    }

    private fun navigateToHomeScreen(){
        navigate(NavigationCommand.To(IntroFragmentDirections.toHomeFragment()))
    }

    private fun setViewPagerChangeCallBack() {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.setCurrentPage(position)
            }
        })
    }

    private fun setUpViewPager() {
        viewPager = getViewDataBinding().viewPager
        viewPager.adapter = viewModel.adapter
        getViewDataBinding().dotsIndicator.setViewPager2(viewPager)
    }

}