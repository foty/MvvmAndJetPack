package com.example.mvvmandjetpack.other.project

import com.example.jetpackdemo.base.view.BaseFragment
import com.example.mvvmandjetpack.R
import com.example.mvvmandjetpack.other.home.HomeViewModel

/**
 * Create by lxx
 * Date : 2020/7/30 17:00
 * Use by
 */
class ProjectFragment : BaseFragment<ProjectViewModel>() {
    override fun getViewModel(): Class<ProjectViewModel> {
    return ProjectViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_project
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initLiveDtaObserver() {
    }
}