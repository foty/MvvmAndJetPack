package com.example.mvvmandjetpack.other.home

import androidx.lifecycle.MutableLiveData
import com.example.mvvmandjetpack.base.viewmodel.BaseViewModel
import com.example.mvvmandjetpack.common.BaseResponse

/**
 * Create by lxx
 * Date : 2020/8/10 15:23
 * Use by
 */
class HomeViewModel : BaseViewModel<HomeRepository>() {

    val mBannerData: MutableLiveData<BaseResponse<List<BannerBean>>> = MutableLiveData()
    val topArticleBean: MutableLiveData<BaseResponse<List<HomeOfTopArticleBean>>> =
        MutableLiveData()
    val homeArticleBean: MutableLiveData<BaseResponse<HomeArticleBean>> = MutableLiveData()


    fun getBanner() {
        repository.getBanner(mBannerData)
    }

    fun getTopArticle() {
        repository.getTopArticle(topArticleBean)
    }

    fun getHomeArticle(page: Int) {
        repository.getHomeArticles(page, homeArticleBean)
    }
}