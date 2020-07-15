package com.example.mvvmandjetpack.other.main

import androidx.lifecycle.MutableLiveData
import com.example.mvvmandjetpack.base.observer.BaseObserver
import com.example.mvvmandjetpack.base.repository.BaseRepository
import com.example.mvvmandjetpack.common.BaseResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by lxx
 * Date : 2020/7/14 14:24
 * Use by
 */
class MainRepository : BaseRepository() {

    fun test(mainBeans: MutableLiveData<BaseResponse<List<SystemTabNameBean>>>) {
        apiService.loadSystemTab()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(BaseObserver(mainBeans, this))
    }
}