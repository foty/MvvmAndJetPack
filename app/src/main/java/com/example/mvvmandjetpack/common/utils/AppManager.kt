
import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*
import kotlin.system.exitProcess

/**
 * Create by lxx
 * Date : 2020/7/13 14:46
 * Use by
 */
class AppManager {

    private val activitys: Stack<Activity> = Stack()

    companion object {
        val instance by lazy {
            AppManager()
        }
    }

    fun add(activity: Activity) {
        activitys.add(activity)
    }

    fun remove(activity: Activity) {
        activitys.remove(activity)
    }

    fun finishAll() {
        for (act in activitys) {
            act.finish()
        }
        activitys.clear()
    }

    /**
     *
     */
    fun exitApp(context :Context) {
        finishAll()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        exitProcess(0)
    }
}