package com.mredrock.cyxbs.freshman.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.BusLineRecycleAdapter
import com.mredrock.cyxbs.freshman.viewmodel.BusLineBean
import com.mredrock.cyxbs.freshman.viewmodel.SchoolSceneryBean
import kotlinx.android.synthetic.main.freshman_fragment_bus_line.*

/**
 *created by chenyang
 *on 2019/8/4
 */


class BusLineFragment : BaseFragment() {

    val datas = ArrayList<BusLineBean>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_bus_line, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialData()

        val manager = LinearLayoutManager(context)
        val adapter = context?.let { BusLineRecycleAdapter(datas, it, R.layout.freshman_recycle_item_bus_line) }

        rv_bus_lines.layoutManager = manager
        rv_bus_lines.adapter = adapter

    }


    private fun initialData() {
        val temp = BusLineBean("重庆北站","""灌灌灌灌-》
            |会你可还好
            |讲究迥异哈哈
            |哪里会你看哈
        """.trimMargin())
        for (i in 1..15) datas.add(temp)

    }
}