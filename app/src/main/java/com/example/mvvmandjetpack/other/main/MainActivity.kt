package com.example.mvvmandjetpack.other.main

import BaseActivity
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.lifecycle.Observer
import com.example.mvvmandjetpack.R
import com.example.mvvmandjetpack.common.startActivity
import com.example.mvvmandjetpack.other.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getViewModel() = MainViewModel::class.java

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        initToolBar()
        initDrawerLayout()

    }


    override fun initData() {
        //发起请求
//        viewModel.getMainData()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.cl_content, HomeFragment())
        transaction.commit()

    }

    //显示menu图片
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    private fun initToolBar() {
        toolbar.title = "首页"
        setSupportActionBar(toolbar) // 利用Toolbar代替ActionBar

        //toolbar关联菜单点击事件
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_scan -> goScan()
                R.id.action_search -> goSearch()
            }
            true
        }

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun initDrawerLayout() {

        navigation_draw.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_menu_rank -> toast("排行榜")
                R.id.nav_menu_square -> toast("广场")
                R.id.nav_menu_collect -> toast("收藏")
                R.id.nav_menu_share -> toast("分享")
                R.id.nav_menu_question -> toast("每日一问")
                R.id.nav_menu_todo -> toast("待办清单")

                R.id.nav_menu_theme -> toast("主题")
                R.id.nav_menu_footprint -> toast("足迹")
                R.id.nav_menu_setting -> toast("设置")
                R.id.nav_menu_logout -> toast("退出登录")
            }
            true
        }
    }

    private fun goSearch() {
        toast("搜索。。。")
    }

    private fun goScan() {
        toast("扫码。。")
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
