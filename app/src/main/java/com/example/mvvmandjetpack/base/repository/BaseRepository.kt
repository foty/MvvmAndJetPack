package com.example.mvvmandjetpack.base.repository

import com.example.mvvmandjetpack.network.ApiService
import com.example.mvvmandjetpack.network.RetrofitManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Create by lxx
 * Date : 2020/7/14 10:27
 * Use by 仓库对数据订阅事件进行管理，使用rx
 */
open class BaseRepository {
    private val disposable by lazy {
        CompositeDisposable()
    }

    protected val apiService: ApiService by lazy {
        RetrofitManager.instance.createApi(apiService::class.java)
    }

    fun addDisposable(d: Disposable) {
        disposable.add(d)
    }

    fun removeDisposable(d: Disposable) {
        disposable.remove(d)
    }

    /**
     * 取消订阅
     */
    fun unSubscribe() {
        disposable.dispose()
    }
}