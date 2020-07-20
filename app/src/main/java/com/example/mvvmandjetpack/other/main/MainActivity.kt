package com.example.mvvmandjetpack.other.main

import BaseActivity
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmandjetpack.R
import com.example.mvvmandjetpack.common.startActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getViewModel() = MainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {

        test_rv.layoutManager = LinearLayoutManager(this)

        var list = mutableListOf<String>()
        for (i in 0..80) {
            list.add("第${i}个item~~~~~~~~~")
        }
        test_rv.adapter = MainAdapter(R.layout.item_text, list)

    }

    override fun initData() {
        //发起请求
//        viewModel.getMainData()

    }

    override fun initLiveDtaObserver() {
        viewModel.mainBean.observe(this, Observer { data ->
            Log.d("lxx", "结束啦啦啦啦啦啦")
            data.data
            data.errorMsg

            startActivity<MainActivity>(this)
        })
    }


}
