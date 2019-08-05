package com.mredrock.cyxbs.freshman.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.FoldRecycleAdapter
import com.mredrock.cyxbs.freshman.viewmodel.FoldBean
import kotlinx.android.synthetic.main.freshman_activity_necessary_goods.*
import java.util.ArrayList

class NecessaryGoodsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_necessary_goods)

        val list = ArrayList<FoldBean>()
        val foldBean = FoldBean("高考准考证","""的方法烦烦烦的
            |芙蓉哥哥
            |鬼玩人果然有黄家驹解可看
            |今天一具体看jjt
            |纪迦太基
        """.trimMargin())
        for (i in 1..15)  list.add(foldBean)

        val adapter = FoldRecycleAdapter(context, list)
        rv_temp.layoutManager = LinearLayoutManager(this)
        rv_temp.adapter = adapter
    }
}
