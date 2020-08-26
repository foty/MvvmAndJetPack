package com.example.mvvmandjetpack.network

import com.example.mvvmandjetpack.common.BaseResponse
import com.example.mvvmandjetpack.other.home.BannerBean
import com.example.mvvmandjetpack.other.home.HomeArticleBean
import com.example.mvvmandjetpack.other.home.HomeOfTopArticleBean
import com.example.mvvmandjetpack.other.main.SystemTabNameBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Create by lxx
 * Date : 2020/7/14 14:45
 * Use by
 */
interface ApiService {

    @GET("/tree/json")
    fun loadSystemTab(): Observable<BaseResponse<List<SystemTabNameBean>>>

    /**
     * home 获取banner图片
     */
    @GET("/banner/json")
    fun loadBanner(): Observable<BaseResponse<List<BannerBean>>>

    /**
     * 置顶文章
     */
    @GET("/article/top/json")
     fun loadTopArticle(): Observable<BaseResponse<List<HomeOfTopArticleBean>>>

    @GET("/article/list/{pageNum}/json")
    fun loadHomeArticle(@Path("pageNum") pageNum: Int): Observable<BaseResponse<HomeArticleBean>>
}