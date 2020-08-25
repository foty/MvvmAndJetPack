package com.example.mvvmandjetpack.other.accounts

import com.example.jetpackdemo.base.view.BaseFragment
import com.example.mvvmandjetpack.R
import com.example.mvvmandjetpack.other.home.HomeViewModel

/**
 * Create by lxx
 * Date : 2020/7/30 16:59
 * Use by
 */
class AccountsFragment : BaseFragment<AccountViewModel>() {
    override fun getViewModel(): Class<AccountViewModel> {
        return AccountViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_account
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initLiveDtaObserver() {
    }
}