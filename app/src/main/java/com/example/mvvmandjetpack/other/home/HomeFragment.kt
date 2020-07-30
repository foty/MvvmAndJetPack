package com.example.mvvmandjetpack.other.home

import android.graphics.Color
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
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
class HomeFragment : BaseFragment() {

    private lateinit var banner: Banner
    private lateinit var adapter: HomeAdapter

    private val imgUrls = arrayListOf(
        "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4" +
                "000_4000&sec=1596093837&di=3b65f40e17409f3c75177919190998f7&src=http://a2.att.hudong.com/86/10/01" +
                "300000184180121920108394217.jpg",
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596103921777&di=b9e094080b2efcd1215" +
                "34293a8adf03f&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F62%2F02%2F01300542526392139955025309984.jpg",
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596103921778&di=57ae8407e3b53ccea80de865" +
                "14a9853c&imgtype=0&src=http%3A%2F%2Fa1.att.hudong.com%2F05%2F00%2F01300000194285122188000535877.jpg"
    )

    private val tittles = arrayListOf("花朵","小猫","小狗")


    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {

        initRefreshLayout()
        initRecyclerView()

    }

    override fun initData() {

        var list = mutableListOf<String>()
        for (i in 0..80) {
            list.add("第${i}个item~~~~~~~~~")
        }
        adapter.setNewData(list)

    }

    override fun initLiveDtaObserver() {
    }

    private fun initRecyclerView() {

        val headView = LayoutInflater.from(activity).inflate(R.layout.layout_home_headview, null)

        initBanner(headView)

        adapter = HomeAdapter(R.layout.item_text)
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

        banner.setBannerTitles(tittles)
        banner.setImages(imgUrls)
        banner.start()
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