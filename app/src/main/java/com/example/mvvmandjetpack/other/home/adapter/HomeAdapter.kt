package com.example.mvvmandjetpack.other.home.adapter

import com.chad.library.adapter.base.BaseViewHolder
import com.example.mvvmandjetpack.R
import com.example.mvvmandjetpack.common.BaseRecyclerAdapter
import com.example.mvvmandjetpack.other.home.HomeOfTopArticleBean

/**
 * Create by lxx
 * Date : 2020/7/30 15:02
 * Use by
 */
class HomeAdapter(layout: Int) : BaseRecyclerAdapter<HomeOfTopArticleBean>(layout) {
    override fun convert(helper: BaseViewHolder, item: HomeOfTopArticleBean) {

        helper.let {
            it.setText(R.id.tvAuthor, String.format("作者: %s", item.author))
            it.setText(R.id.tvPushTime, item.niceDate)
            it.setText(R.id.tvTittle, item.title)
            it.setText(R.id.tvClassify, handClassify(item))
            it.setVisible(R.id.tvNew,item.fresh)
            it.setVisible(R.id.tvTopTag,item.top)
        }


    }

    private fun handClassify(item: HomeOfTopArticleBean): String {
        return when {
            item.superChapterName.isNullOrEmpty() and item.chapterName.isNullOrEmpty() -> ""
            item.superChapterName.isNullOrEmpty() -> item.chapterName ?: ""
            item.chapterName.isNullOrEmpty() -> item.superChapterName ?: ""
            else -> "${item.superChapterName} ${item.chapterName}"
        }
    }

}