package com.example.mvvmclean.ui.intro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseViewModel
import com.example.mvvmclean.data.repository.DataStoreRepository
import com.example.mvvmclean.ui.intro.adapter.IntroPagerAdapter
import com.example.mvvmclean.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroVM @Inject constructor (
     dataStoreRepository: DataStoreRepository
) : BaseViewModel(){

    val isFirstTimeLogin:Boolean = dataStoreRepository.getIsFirstTimeAppUse.asLiveData().value ?: false
    val navigateToMainScreen: SingleLiveEvent<Boolean> = SingleLiveEvent()
    private val _currentPage = MutableLiveData(0)
    val currentPage: LiveData<Int> get() = _currentPage

    val adapter: IntroPagerAdapter by lazy {
        IntroPagerAdapter(
            listOf("Your Key to the Best Deals",
                "Simplified Buying & Selling",
                "Stay Updated on Market Trends",
                "Find Your Investment Opportunities"),
            listOf("Unlock exclusive listings and unbeatable prices in your desired neighborhoods. Start your journey to homeownership today!",
                "Navigate the real estate market effortlessly with our user-friendly tools designed to streamline your buying or selling process",
                "Keep your finger on the pulse of the real estate market with regular updates on pricing, availability, and market shifts",
                "Whether you're a first-time buyer or a seasoned investor, discover lucrative properties that align with your financial goals"),
            listOf(R.drawable.ic_intro_1, R.drawable.ic_intro_2, R.drawable.ic_intro_3,R.drawable.ic_intro_4)
        )
    }

    val nextButtonText: LiveData<String> = MediatorLiveData<String>().apply {
        addSource(currentPage) { page ->
            value = if (page == adapter.itemCount - 1) "Okay" else "Next"
        }
    }

    val isSkipVisible: LiveData<Boolean> = MediatorLiveData<Boolean>().apply {
        addSource(currentPage) { page ->
            value = page != adapter.itemCount - 1
        }
    }

    fun onNextClicked() {
        val nextPage = _currentPage.value?.plus(1) ?: 0
        if (nextPage < adapter.itemCount) {
            _currentPage.value = nextPage
        } else {
           navigateToMainScreen.value = true
        }
    }

    fun onSkipClicked() {
//        _currentPage.value = adapter.itemCount - 1
        navigateToMainScreen.value = true
    }

    fun setCurrentPage(page: Int) {
        _currentPage.value = page
    }
}