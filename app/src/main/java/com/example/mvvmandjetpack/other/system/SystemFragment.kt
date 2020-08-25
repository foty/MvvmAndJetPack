package com.example.mvvmandjetpack.other.system

import com.example.jetpackdemo.base.view.BaseFragment
import com.example.mvvmandjetpack.R
import com.example.mvvmandjetpack.other.home.HomeViewModel

/**
 * Create by lxx
 * Date : 2020/7/30 16:58
 * Use by
 */
class SystemFragment : BaseFragment<SystemViewModel>() {
    override fun getViewModel(): Class<SystemViewModel> {
        return SystemViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_system
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initLiveDtaObserver() {
    }
}