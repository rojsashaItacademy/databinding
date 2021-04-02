package ru.trinitydigital.databinfingvm.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

class SimpleBindingRvAdapter<T>(
    @LayoutRes private val holderLayout: Int,
    private val variableId: Int
) : BaseBindingRvAdapter<T, SimpleBindingRvAdapter.SimpleBindingViewHolder<T>>() {

    override fun createViewHolderInstance(
        parent: ViewGroup,
        viewType: Int
    ): SimpleBindingViewHolder<T> {
        return SimpleBindingViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                holderLayout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SimpleBindingViewHolder<T>, position: Int) {
        val item = items[position]
        holder.binding.setVariable(variableId, item)
    }

    open class SimpleBindingViewHolder<T>(binding: ViewDataBinding) :
        BaseBindingRvAdapter.BaseBindingRvViewHolder<T>(binding)
}