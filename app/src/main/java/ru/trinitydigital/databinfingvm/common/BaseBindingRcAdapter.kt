package ru.trinitydigital.databinfingvm.common

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding

abstract class BaseBindingRvAdapter<Model, VH : BaseBindingRvAdapter.BaseBindingRvViewHolder<Model>>(
    protected var items: MutableList<Model> = mutableListOf()
) :
    LiveDataBindingRecyclerViewAdapter<VH>() {

    abstract fun createViewHolderInstance(parent: ViewGroup, viewType: Int): VH

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return createViewHolderInstance(parent, viewType).apply {
            binding.lifecycleOwner = this
        }
    }

    fun updateItems(items: MutableList<Model>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    open class BaseBindingRvViewHolder<Model>(val binding: ViewDataBinding) :
        LiveDataBindingViewHolder(binding.root) {
        open fun bind(model: Model, variableId: Int = 0) {}

    }
}


