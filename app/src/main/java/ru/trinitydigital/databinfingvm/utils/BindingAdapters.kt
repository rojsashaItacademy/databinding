package ru.trinitydigital.databinfingvm.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.trinitydigital.databinfingvm.common.BaseBindingRvAdapter
import java.lang.IllegalStateException

@BindingAdapter("android:items")
fun <T> RecyclerView.bindItems(items: MutableList<T>?) {
    items?.let {
        try {
            (adapter as BaseBindingRvAdapter<T, *>).updateItems(items)
        } catch (t: Throwable) {
            throw IllegalStateException("incompatible types")
        }
    }
}