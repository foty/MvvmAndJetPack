package com.example.mvvmandjetpack.other.main

import androidx.lifecycle.MutableLiveData
import com.example.mvvmandjetpack.base.viewmodel.BaseViewModel
import com.example.mvvmandjetpack.common.BaseResponse

/**
 * Create by lxx
 * Date : 2020/7/14 14:16
 * Use by
 */
class MainViewModel : BaseViewModel<MainRepository>() {

    val mainBean: MutableLiveData<BaseResponse<List<SystemTabNameBean>>> = MutableLiveData()

    fun getMainData(){
        repository.test(mainBean)
    }
}