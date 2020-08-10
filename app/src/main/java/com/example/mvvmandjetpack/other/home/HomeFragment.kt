package com.example.mvvmandjetpack.other.home

import android.graphics.Color
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpackdemo.base.view.BaseFragment
import com.example.mvvmandjetpack.R
import com.example.mvvmandjetpack.common.utils.GlideImageLoader
import com.example.mvvmandjetpack.other.home.adapter.HomeAdapter
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_home_headview.view.*
import org.jetbrains.anko.toast

/**
 * Create by lxx
 * Date : 2020/7/30 14:00
 * Use by
 */
class HomeFragment : BaseFragment<HomeViewModel>() {

    private lateinit var banner: Banner
    private lateinit var adapter: HomeAdapter

    private val imgUrls by lazy {
        arrayListOf<String>()
    }

    private val tittles by lazy {
        arrayListOf<String>()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {

        initRefreshLayout()
        initRecyclerView()

    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun initData() {

        var list = mutableListOf<String>()
        for (i in 0..80) {
            list.add("第${i}个item~~~~~~~~~")
        }
        adapter.setNewData(list)

        viewModel.getBanner()

    }

    override fun initLiveDtaObserver() {
        viewModel.mBannerData.observe(this, Observer {

            if (it.errorCode != 0) {
                return@Observer
            }
            tittles.clear()
            imgUrls.clear()
            for (item in it.data) {
                tittles.add(item.desc)
                imgUrls.add(item.imagePath)
            }
            banner.setBannerTitles(tittles)
            banner.setImages(imgUrls)
            banner.start()
        })
    }

    private fun initRecyclerView() {

        val headView = LayoutInflater.from(activity).inflate(R.layout.layout_home_headview, null)

        initBanner(headView)

        adapter = HomeAdapter(R.layout.item_home_list)
        adapter.setHeaderView(headView)

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

    }

    private fun initBanner(headView: View) {
        banner = headView.mBanner // also with run let
        banner.apply {
            setDelayTime(5000)
            setImageLoader(GlideImageLoader())
            setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
            setOnBannerListener { position ->
                context?.toast("$position")
            }
        }
    }

    private fun initRefreshLayout() {
        refreshLayout.setProgressBackgroundColorSchemeColor(Color.parseColor("#008577"))
        refreshLayout.setColorSchemeColors(Color.WHITE)
        refreshLayout.setOnRefreshListener { refreshData() }
    }

    private fun refreshData() {

        Handler().postDelayed({
            context?.toast("刷新完成")
            refreshLayout.isRefreshing = false

        }, 2000)

    }
}