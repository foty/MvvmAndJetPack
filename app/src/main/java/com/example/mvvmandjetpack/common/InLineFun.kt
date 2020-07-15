package com.example.mvvmandjetpack.common

import android.content.Context
import android.content.Intent

/**
 * Create by lxx
 * Date : 2020/7/15 15:38
 * Use by 内联方法文件
 */

inline fun <reified T> startActivity(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)
}