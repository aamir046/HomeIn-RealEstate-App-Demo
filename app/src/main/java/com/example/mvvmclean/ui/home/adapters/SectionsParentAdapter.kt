package com.example.mvvmclean.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvmclean.BR
import com.example.mvvmclean.R
import com.example.mvvmclean.ui.home.Section

class ParentAdapter(private val sections: List<Section>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (sections[position]) {
            is Section.StoriesSection -> R.layout.item_sections_stories
            is Section.FeaturedSection -> R.layout.item_sections_properties
            is Section.AgentSection -> R.layout.item_sections_developers
            is Section.DiscountOfferSection -> R.layout.item_section_discount_offer  // New type for Discount Offer
            is Section.AgentDiscountViewPagerSection -> R.layout.item_section_agent_discount_viewpager  // New type for Agent Discount ViewPager
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), viewType, parent, false
        )
        return SectionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SectionViewHolder).bind(sections[position])
    }

    override fun getItemCount() = sections.size

    inner class SectionViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(section: Section) {
            when (section) {
                is Section.StoriesSection -> {
                    // Set up horizontal adapter for recommended properties
                    val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerHorizontal)
                    recyclerView.adapter = SectionsHorizontalAdapter(section.stories, R.layout.item_story, BR.story)
                }
                is Section.FeaturedSection -> {
                    // Set up horizontal adapter for featured properties
                    val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerHorizontal)
                    recyclerView.adapter = SectionsHorizontalAdapter(section.properties, R.layout.item_property, BR.property)
                }
                is Section.AgentSection -> {
                    // Set up horizontal adapter for agents
                    val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerHorizontal)
                    recyclerView.adapter = SectionsHorizontalAdapter(section.agents, R.layout.item_developers, BR.agent)
                }
                is Section.DiscountOfferSection -> {
                    // Bind discount offer data to the TextView
                    binding.setVariable(BR.section, section)
                    binding.executePendingBindings()
                }
                is Section.AgentDiscountViewPagerSection -> {
                    // Set up ViewPager2 adapter for discounted agents
                    val viewPager = binding.root.findViewById<ViewPager2>(R.id.viewPagerDiscountedAgents)
                    viewPager.adapter = DiscountedAgentViewPagerAdapter(section.discountedAgents)
                }
            }
        }
    }
}
