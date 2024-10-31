package com.example.mvvmclean.ui.intro.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmclean.databinding.IntroPageItemBinding

class IntroPagerAdapter(
    private val titles: List<String>,
    private val descriptions: List<String>,
    private val imageIcons: List<Int>
) : RecyclerView.Adapter<IntroPagerAdapter.IntroViewHolder>() {

    inner class IntroViewHolder(private val binding: IntroPageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(title: String, description: String,imageIcon:Int) {
            binding.title = title
            binding.description = description
            binding.imageIcon = imageIcon
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = IntroPageItemBinding.inflate(inflater, parent, false)
        return IntroViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(titles[position], descriptions[position],imageIcons[position])
    }

    override fun getItemCount(): Int = titles.size
}
