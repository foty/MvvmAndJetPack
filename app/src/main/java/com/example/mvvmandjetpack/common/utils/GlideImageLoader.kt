package com.example.mvvmandjetpack.common.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

/**
 * Create by lxx
 * Date : 2020/7/30 14:42
 * Use by
 */
class GlideImageLoader :ImageLoader() {
    override fun displayImage(context: Context, path: Any?, imageView: ImageView) {
        Glide.with(context).load(path).into(imageView)
    }
}