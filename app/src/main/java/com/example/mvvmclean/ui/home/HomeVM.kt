package com.example.mvvmclean.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseViewModel
import com.example.mvvmclean.data.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor (
     val dataStoreRepository: DataStoreRepository
) : BaseViewModel(){
    
    private val _sections = MutableLiveData<List<Section>>()
    val sections: LiveData<List<Section>> = _sections

    init {
        _sections.value = listOf(
            Section.StoriesSection(listOf(
                Story(1, "About HomeIn Project", "Description", R.drawable.ic_story_1),
                Story(1, "How to chose best Property", "Description", R.drawable.ic_property_image))
            ),
            Section.FeaturedSection(listOf(
                Property(2, "Featured Property", R.drawable.ic_property_image),
                Property(2, "Featured Property", R.drawable.ic_story_1))
            ),
            Section.AgentSection(listOf(
                Agent(1, R.drawable.ic_logo_meeras),
                Agent(1, R.drawable.ic_logo_danube),
                Agent(1, R.drawable.ic_logo_nashama),
                Agent(1, R.drawable.ic_logo_dubai_properties),
                Agent(1, R.drawable.ic_logo_dp))
            ),
            Section.DiscountOfferSection(offer = "Upcoming Discount Offers"),
            Section.AgentDiscountViewPagerSection(listOf(
                DiscountedAgent(1, "Danube Properties",R.drawable.ic_logo_danube,"Zero Commission Fee for Early Birds!","Book your property with Danube Properties now, and pay no agent commission fees. Grab the deal before it’s gone!","Till: January 15, 2025"),
                DiscountedAgent(1, "Aldar Properties",R.drawable.ic_aldar_logo,"Celebrate with Big Savings on Your Home!","As part of the New Year Festival, enjoy up to 15% off on premium apartments and villas listed by Aldar Properties","Till: January 31, 2025"),
                DiscountedAgent(1, "Emaar Properties",R.drawable.ic_logo_emaar_properties,"Earn Cashback on Every Registration!","Get up to 5% cashback on successful property registration with Estate Experts. Offer available for properties registered","January 1, 2025 - March 15, 2025"),
                DiscountedAgent(1, "Dubai Properties",R.drawable.ic_logo_dubai_properties,"Refer and Earn Big Discounts!"," Refer a friend to buy a property with Sunshine Realty and get 5% off on your next purchase. Unlimited referrals allowed!","Starting: November 1, 2024"))
            )
        )
    }
}