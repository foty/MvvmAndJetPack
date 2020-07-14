package com.example.mvvmandjetpack

import BaseActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getViewModel() = MainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

    }

    override fun initData() {
        //发起请求
        viewModel.getMainData()

    }

    override fun initLiveDtaObserver() {
        viewModel.mainBean.observe(this, Observer { data ->
            data.data
            data.errorMsg
        })
    }


}
