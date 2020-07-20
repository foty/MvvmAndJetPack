package com.example.mvvmandjetpack.other.main

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.mvvmandjetpack.R

/**
 * Create by lxx
 * Date : 2020/7/20 14:26
 * Use by
 */
class MainAdapter(layout: Int, list: MutableList<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(layout, list) {
    override fun convert(helper: BaseViewHolder, item: String) {

        helper.setText(R.id.tv, item)

    }
}