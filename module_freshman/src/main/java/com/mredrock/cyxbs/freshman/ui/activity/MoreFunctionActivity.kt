package com.mredrock.cyxbs.freshman.ui.activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.MyImageLoader
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.freshman_activity_main.*
import kotlinx.android.synthetic.main.freshman_activity_more_function.*
import kotlinx.android.synthetic.main.freshman_more_dialog.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.*
import java.lang.StringBuilder

class MoreFunctionActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    private var dialog : Dialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_more_function)
        common_toolbar.init(
            title = "更多功能",
            listener = View.OnClickListener { v -> finish() }
        )
        dialog = Dialog(this, R.style.freshman_edit_AlertDialog_style)
        dialog!!.setContentView(R.layout.freshman_more_dialog)
        dialog!!.iv_more_dia.setBackgroundResource(R.drawable.code)
        dialog!!.setCanceledOnTouchOutside(true)
        val window = dialog!!.window
        val lp: WindowManager.LayoutParams = window.attributes
        lp.x = 0
        lp.y = 40
        dialog!!.onWindowAttributesChanged(lp)
        dialog!!.iv_more_dia.setOnClickListener { v -> dialog!!.dismiss() }
        rl_more_third.setOnClickListener { v -> dialog!!.show() }
    }
}
