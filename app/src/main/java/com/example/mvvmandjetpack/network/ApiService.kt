package com.example.mvvmandjetpack.network

import com.example.mvvmandjetpack.other.main.SystemTabNameBean
import com.example.mvvmandjetpack.common.BaseResponse
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
}