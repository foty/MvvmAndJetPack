package com.example.mvvmandjetpack.common

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Create by lxx
 * Date : 2020/7/30 15:04
 * Use by
 */
abstract class BaseRecyclerAdapter<T>(layout: Int) :
    BaseQuickAdapter<T, BaseViewHolder>(layout, null)
