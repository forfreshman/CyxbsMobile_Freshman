package com.mredrock.cyxbs.freshman.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.OnInitalRecycleIMClikListener
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.InitialRecycleAdapter
import com.mredrock.cyxbs.freshman.viewmodel.InitialItem
import com.mredrock.cyxbs.freshman.ui.adapter.InitialRecyclerView
import kotlinx.android.synthetic.main.freshman_activity_main.*

class MainActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    val datas = ArrayList<InitialItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_main)


        initialData()
        val initialRecyclerViewAdapter = InitialRecycleAdapter(context, datas as List<InitialItem>)

        initialRecyclerViewAdapter.setItemOnclicListener(object :OnInitalRecycleIMClikListener{
            override fun OnCilick(mainTitle: String?) {
                var intent: Intent? = null
                LogUtils.d("*******","被电击了")
                when (mainTitle) {
                    "入学必备" ->
                        intent = Intent(context, NecessaryGoodsActivity::class.java)
                    "指路重邮" ->
                        intent = Intent(context, ShowWayActivity::class.java)
                    "入学流程" -> LogUtils.d("", "")
                    "校园指导" -> LogUtils.d("", "")
                    "线上活动" -> LogUtils.d("", "")
                    "更多功能" -> LogUtils.d("", "")
                    "关于我们" -> LogUtils.d("", "")
                }
                startActivity(intent)
            }

        })
        val recyclerViewAdapter = InitialRecyclerView(
            this, datas, layoutInflater,
            R.layout.freshman_recycle_item_initial, 1
        )
        rv_initial_page.layoutManager = LinearLayoutManager(this)
        rv_initial_page.adapter = recyclerViewAdapter
        //主页右侧的箭头，点击之后，会跳转到相应的页面

//        val bu:Button;
//        bu.setOnClickListener{v ->
//            val intent  = Intent(this, AnotherActivity::class.java)
//            startActivity(intent)
//        }


    }

    private fun initialData() {
        val one = InitialItem("入学必备","报道必备 宿舍用品 学习用品")
        datas.add(one)
        val two = InitialItem("指路重邮","重游路线 重邮地图")
        datas.add(two)
        val three = InitialItem("入学流程","入学步骤 入学地点")
        datas.add(three)
        val four = InitialItem("校园指导","校舍 快递点指引")
        datas.add(four)
        val five = InitialItem("线上活动","校舍 快递点指引")
        datas.add(five)
        val six = InitialItem("更多功能","迎新网 新生课表")
        datas.add(six)
        val seven = InitialItem("关于我们","红岩网校")
        datas.add(seven)
//        initialItem.setMainTitle("指路重邮").setSubhead("重游路线、重邮地图")
//        datas.add(initialItem)
//        initialItem.setMainTitle("入学流程").setSubhead("入学步骤、入学地点")
//        datas.add(initialItem)
//        initialItem.setMainTitle("校园指导").setSubhead("校舍、快递点指引")
//        datas.add(initialItem)
//        initialItem.setMainTitle("线上活动").setSubhead("老乡群、专业群")
//        datas.add(initialItem)
//        initialItem.setMainTitle("更多功能").setSubhead("迎新网、新生课表")
//        datas.add(initialItem)
//        initialItem.setMainTitle("关于我们").setSubhead("红岩网校")
//        datas.add(initialItem)

    }
}
