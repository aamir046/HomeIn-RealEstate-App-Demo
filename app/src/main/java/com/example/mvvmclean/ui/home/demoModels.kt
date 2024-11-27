package com.example.mvvmclean.ui.home

data class Story(val id: Int, val title: String,val description:String, val imageUrl: Int)
data class Property(val id: Int, val title: String, val imageUrl: Int)
data class Agent(val id: Int, val logoUrl: Int)
data class DiscountedAgent(val id: Int, val agentName: String,val logoUrl: Int, val discountTitle: String, val discountDescription: String, val discountDate: String)

sealed class Section {
    data class StoriesSection(val stories: List<Story>) : Section()
    data class FeaturedSection(val properties: List<Property>) : Section()
    data class AgentSection(val agents: List<Agent>) : Section()
    data class DiscountOfferSection(val offer: String) : Section()
    data class AgentDiscountViewPagerSection(val discountedAgents: List<DiscountedAgent>) : Section()
}
