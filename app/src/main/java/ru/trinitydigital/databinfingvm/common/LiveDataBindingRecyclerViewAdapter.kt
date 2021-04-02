package ru.trinitydigital.databinfingvm.common

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.recyclerview.widget.RecyclerView

abstract class LiveDataBindingRecyclerViewAdapter<T : LiveDataBindingViewHolder> :
    RecyclerView.Adapter<T>() {

    override fun onViewAttachedToWindow(holder: T) {
        super.onViewAttachedToWindow(holder)
        holder.markAttach()
    }

    override fun onViewDetachedFromWindow(holder: T) {
        super.onViewDetachedFromWindow(holder)
        holder.markDetach()
    }
}

open class LiveDataBindingViewHolder(view: View) : RecyclerView.ViewHolder(view), LifecycleOwner {

    private val lifeCycleRegistered = LifecycleRegistry(this)

    init {
        lifeCycleRegistered.currentState = Lifecycle.State.INITIALIZED
    }

    fun markAttach() {
        lifeCycleRegistered.currentState = Lifecycle.State.STARTED
    }

    fun markDetach() {
        lifeCycleRegistered.currentState = Lifecycle.State.CREATED
    }

    override fun getLifecycle() = lifeCycleRegistered

}
