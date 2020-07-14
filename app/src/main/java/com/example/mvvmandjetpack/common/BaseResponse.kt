package com.example.mvvmandjetpack.common

/**
 * Create by lxx
 * Date : 2020/7/14 11:37
 * Use by 接收数据基类。
 */
class BaseResponse<T>(var data: T, var errorCode: Int = 0, var errorMsg: String = "")
