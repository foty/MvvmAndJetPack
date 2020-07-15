package com.example.mvvmandjetpack.common

import android.text.TextUtils
import android.widget.TextView

/**
 * Create by lxx
 * Date : 2020/7/15 15:55
 * Use by 扩展函数文件
 */

fun TextView.isEmpty(): Boolean {
    return TextUtils.isEmpty(text)
}