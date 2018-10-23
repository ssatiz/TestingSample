package com.testing.sample.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by SunTrust on 10/18/2018.
 */
abstract class BaseViewHolder<in T>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun onBind(any: T?)
}