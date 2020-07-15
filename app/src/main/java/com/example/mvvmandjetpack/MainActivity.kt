package com.example.mvvmandjetpack

import BaseActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
          Log.d("lxx", "结束啦啦啦啦啦啦")
            data.data
            data.errorMsg
        })
    }


}
