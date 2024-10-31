package com.example.mvvmclean.base

interface BaseItemListener<T> {
    fun onItemClick(item: T)
}