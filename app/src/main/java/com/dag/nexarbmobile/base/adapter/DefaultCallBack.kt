package com.dag.nexarbmobile.base.adapter

import androidx.recyclerview.widget.DiffUtil

class DefaultCallBack<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean = oldItem === newItem

    override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean = oldItem == newItem
}
