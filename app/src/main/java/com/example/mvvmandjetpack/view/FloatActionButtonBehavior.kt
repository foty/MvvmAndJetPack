package com.example.mvvmandjetpack.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * Create by lxx
 * Date : 2020/7/20 11:42
 * Use by 自定义的FloatingActionButton behavior。
 * 主要做2件事情: 1：判断垂直方向需要触发回调；2：下滑按钮隐藏，上滑按钮显示。
 */
class FloatActionButtonBehavior(context: Context, attrs: AttributeSet) :
    FloatingActionButton.Behavior() {

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: FloatingActionButton,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        super.onNestedScroll(
            coordinatorLayout,
            child,
            target,
            dxConsumed,
            dyConsumed,
            dxUnconsumed,
            dyUnconsumed,
            type,
            consumed
        )
        //判断上滑隐藏，下滑显示。
        if (dyConsumed > 0 && child.visibility == View.VISIBLE) {
            child.visibility = View.INVISIBLE //这里不能设置view 的属性为GONE，会导致fab与父布局失去关联，此方法将不被调用。
        } else if (dyConsumed <= 0 && child.visibility != View.VISIBLE) {
            child.visibility = View.VISIBLE
        }

    }
}