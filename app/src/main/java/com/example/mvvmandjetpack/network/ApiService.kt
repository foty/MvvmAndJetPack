package com.example.mvvmandjetpack.network

import com.example.mvvmandjetpack.common.BaseResponse
import com.example.mvvmandjetpack.other.home.BannerBean
import com.example.mvvmandjetpack.other.main.SystemTabNameBean
import io.reactivex.Observable
import retrofit2.http.GET

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
}