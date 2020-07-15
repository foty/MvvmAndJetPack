package com.example.mvvmandjetpack.base.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mvvmandjetpack.base.repository.BaseRepository
import java.lang.reflect.ParameterizedType

/**
 * Create by lxx
 * Date : 2020/7/14 10:23
 * Use by
 */
open class BaseViewModel<T : BaseRepository> : ViewModel() {

    //反射初始化repository
    val repository: T by lazy {
        ((javaClass.genericSuperclass
                as ParameterizedType).actualTypeArguments[0]
                as Class<T>) // 获取对应Repository实例
            .getDeclaredConstructor() //获取构造函数构造器,这里不需要参数
            .newInstance()
    }

    /**
     * 重写函数，ViewModel生命周期结束会调用此方法
     */
    override fun onCleared() {
        super.onCleared()
        repository.unSubscribe()
    }
}