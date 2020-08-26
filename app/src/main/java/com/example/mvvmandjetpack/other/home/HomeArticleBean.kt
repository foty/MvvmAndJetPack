package com.example.mvvmandjetpack.other.home

/**
 * Create by lxx
 * Date : 2020/8/26 15:44
 * Use by
 */
data class HomeArticleBean(
    var curPage: Int,
    var datas: List<HomeOfTopArticleBean>,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Int
)