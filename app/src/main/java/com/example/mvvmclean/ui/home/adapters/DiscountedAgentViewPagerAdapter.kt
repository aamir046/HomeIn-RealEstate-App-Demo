package com.example.mvvmclean.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.mvvmclean.BR
import com.example.mvvmclean.R
import com.example.mvvmclean.ui.home.Agent
import com.example.mvvmclean.ui.home.DiscountedAgent

class DiscountedAgentViewPagerAdapter(private val agents: List<DiscountedAgent>) : RecyclerView.Adapter<DiscountedAgentViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(agent: DiscountedAgent) {
            binding.setVariable(BR.agent, agent)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.item_discount_from_agents, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(agents[position])
    }

    override fun getItemCount() = agents.size
}
