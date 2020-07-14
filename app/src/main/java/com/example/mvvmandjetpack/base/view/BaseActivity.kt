import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmandjetpack.base.viewmodel.BaseViewModel
import org.jetbrains.anko.toast

/**
 * Create by lxx
 * Date : 2020/7/13 14:38
 * Use by
 */
abstract class BaseActivity<VM : BaseViewModel<*>> : AppCompatActivity() {

    private var exitTime: Long = 0

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        AppManager.instance.add(this)

        viewModel = ViewModelProvider(this).get(getViewModel())
        initView()
        initData()

        //统一处理livedata的回调
        initLiveDtaObserver()
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    abstract fun initLiveDtaObserver()

    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.remove(this)
    }

    override fun onBackPressed() {
        super.onBackPressed()

        val cTime = System.currentTimeMillis()
        if (cTime - exitTime > 2000) {
            exitTime = cTime
            toast("再按一次退出")
        } else {
            AppManager.instance.exitApp()
        }
    }

}