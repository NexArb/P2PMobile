package com.dag.nexarbmobile.base.adapter

fun interface ItemClickListener<T> {

    fun onClick(position: Int, item: T)
}
