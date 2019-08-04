package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.viewmodel.BusLineBean
import com.mredrock.cyxbs.freshman.viewmodel.SchoolSceneryBean
import kotlinx.android.synthetic.main.freshman_recycle_item_bus_line.view.*
import kotlinx.android.synthetic.main.freshman_recycle_item_scenery.view.*

/**
 *created by chenyang
 *on 2019/8/4
 */
class BusLineRecycleAdapter(val datas: List<BusLineBean>, val context: Context,
                                override val latoutId: Int) :
    BaseAdapter<BusLineBean>(datas, context) {

    //标记展开的item
    private var opened = -1

    override fun creatHolder(holder: BaseViewHolder, t: BusLineBean) {

        val startStation = holder.getView().tv_start_bus_station
        val speficBusLine = holder.getView().tv_spefic_bus_line

        startStation.setText(t.startStaton)
        speficBusLine.setText(t.sepficLine)

        val position = datas.indexOf(t)
        if ( position == opened) {
            speficBusLine.visibility = View.VISIBLE
        } else {
            speficBusLine.visibility = View.GONE
        }


        //当箭头点击之后决定是展开具体路线还是收起具体路线
        holder.getView().iv_spefic_bus_line_flod.setOnClickListener{v ->

            if (opened == holder.adapterPosition) {
                //当前item已经被展开，关闭
                opened = -1
                notifyItemChanged(holder.adapterPosition)
            } else {
                val oldOpend = opened
                opened = holder.adapterPosition
                notifyItemChanged(oldOpend)
                notifyItemChanged(opened)
            }

        }
    }



}