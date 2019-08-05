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
        val foldBean = FoldBean("defwefwef","的方法烦烦烦的 ")
        for (i in 1..15)  list.add(foldBean)

        val adapter = FoldRecycleAdapter(context, list)
        rv_temp.layoutManager = LinearLayoutManager(this)
        rv_temp.adapter = adapter
    }
}
