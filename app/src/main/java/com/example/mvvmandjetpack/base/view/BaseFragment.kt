package com.example.jetpackdemo.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmandjetpack.base.viewmodel.BaseViewModel

/**
 * Create by lxx
 * Date : 2020/7/13 15:08
 * Use by
 */
abstract class BaseFragment<VM : BaseViewModel<*>> : Fragment() {

    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(getLayoutId(), null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        viewModel = ViewModelProvider(this).get(getViewModel())
        initData()

        initLiveDtaObserver()
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun initLiveDtaObserver()

    override fun onDestroyView() {
        super.onDestroyView()
    }
}