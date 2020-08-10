package com.example.mvvmandjetpack.other.home

import androidx.lifecycle.MutableLiveData
import com.example.mvvmandjetpack.base.observer.BaseObserver
import com.example.mvvmandjetpack.base.repository.BaseRepository
import com.example.mvvmandjetpack.common.BaseResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Create by lxx
 * Date : 2020/8/10 15:24
 * Use by
 */
class HomeRepository : BaseRepository() {

    fun getBanner(liveData: MutableLiveData<BaseResponse<List<BannerBean>>>) {
        apiService.loadBanner()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(BaseObserver(liveData, this))
    }
}