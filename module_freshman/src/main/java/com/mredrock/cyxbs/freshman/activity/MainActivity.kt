package com.mredrock.cyxbs.freshman.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.BR
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.adapters.InitialRecyclerView
import com.mredrock.cyxbs.freshman.viewmodel.InitialPage
import kotlinx.android.synthetic.main.freshman_activity_main.*

class MainActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    val datas = ArrayList<InitialPage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_main)


        initialData()
        val recyclerViewAdapter = InitialRecyclerView(this, datas, layoutInflater,
            R.layout.freshman_recycle_item_initial,1
            //BR.initialItem
        )
        rv_initial_page.layoutManager = LinearLayoutManager(this)
        rv_initial_page.adapter = recyclerViewAdapter
    }

    private fun initialData() {
        val initialItem = InitialPage("入学必备","报道必备、宿舍用品、学习用品")
        datas.add(initialItem)
        initialItem.setMainTitle("指路重邮").setSubhead("重游路线、重邮地图")
        datas.add(initialItem)
        initialItem.setMainTitle("入学流程").setSubhead("入学步骤、入学地点")
        datas.add(initialItem)
        initialItem.setMainTitle("校园指导").setSubhead("校舍、快递点指引")
        datas.add(initialItem)
        initialItem.setMainTitle("线上活动").setSubhead("老乡群、专业群")
        datas.add(initialItem)
        initialItem.setMainTitle("更多功能").setSubhead("迎新网、新生课表")
        datas.add(initialItem)
        initialItem.setMainTitle("关于我们").setSubhead("红岩网校")
        datas.add(initialItem)

    }
}
