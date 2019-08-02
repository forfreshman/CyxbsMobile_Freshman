package com.mredrock.cyxbs.freshman

import android.os.Bundle
import com.mredrock.cyxbs.common.ui.BaseActivity

class MainActivity(override val isFragmentActivity: Boolean) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_main)
    }
}
