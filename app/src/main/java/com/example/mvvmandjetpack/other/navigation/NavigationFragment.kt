package com.example.mvvmandjetpack.other.navigation

import com.example.jetpackdemo.base.view.BaseFragment
import com.example.mvvmandjetpack.R
import com.example.mvvmandjetpack.other.home.HomeViewModel

/**
 * Create by lxx
 * Date : 2020/7/30 16:59
 * Use by
 */
class NavigationFragment : BaseFragment<NavigationViewModel>() {
    override fun getViewModel(): Class<NavigationViewModel> {
        return NavigationViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_navigation
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initLiveDtaObserver() {
    }
}