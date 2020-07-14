package com.example.mvvmandjetpack.base.observer

import androidx.lifecycle.MutableLiveData
import com.example.mvvmandjetpack.common.BaseResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Create by lxx
 * Date : 2020/7/14 10:26
 * Use by
 */
class BaseObserver<T : BaseResponse<*>>(val liveData: MutableLiveData<T>) : Observer<T> {

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(response: T) {

        //此方法设置，Observer的onChanged()方法将会被调用。
        liveData.postValue(response)
    }

    override fun onError(e: Throwable) {
    }
}