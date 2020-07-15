package com.example.mvvmandjetpack.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Create by lxx
 * Date : 2020/7/14 14:47
 * Use by retrofit管理器。负责创建配置请求实例
 */
class RetrofitManager private constructor() {
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttpClient())//设置okhttp的实例
            .build()
    }

    fun <T> createApi(clazz: Class<T>): T = retrofit.create(clazz)

    companion object {
        val instance by lazy {
            RetrofitManager()
        }
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30000, TimeUnit.MILLISECONDS)
            .readTimeout(30000, TimeUnit.MILLISECONDS)
            .writeTimeout(30000, TimeUnit.MILLISECONDS)
            .addInterceptor( //log拦截器
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .addInterceptor(commonInterceptor()) //请求头参数
            .addInterceptor(cookieInterceptor()) //cookie/token
            .build()
    }

    /**
     * 设置公共请求头
     */
    private fun commonInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("charset", "UTF-8")
                .build()
            chain.proceed(request)
        }
    }

    private fun cookieInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(request)
            val url = request.url().toString() //请求链接
            val cookie = response.header("Set-Cookie")
            saveCookie(cookie)
            response
        }
    }

    /**
     * 保存cookie
     */
    private fun saveCookie(cookie: String?) {
        cookie?.let {
            Log.e("", "cookie= $cookie")
        }
    }
}