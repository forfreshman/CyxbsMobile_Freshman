package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.View
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.ShowWayActivity
import com.mredrock.cyxbs.freshman.viewmodel.bean.BusLineBean
import kotlinx.android.synthetic.main.freshman_recycle_item_bus_line.view.*

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

        if (holder.getView().tv_spefic_bus_line.visibility == View.VISIBLE){
            holder.getView().iv_spefic_bus_line_flod.setImageResource(R.drawable.freshman_necessary_fold_icon_up)
        }

        //当箭头点击之后决定是展开具体路线还是收起具体路线
        holder.getView().setOnClickListener{v ->

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

        holder.setVisiable()
    }

    private fun BaseAdapter.BaseViewHolder.setVisiable(){
        val view = getView()
        view.setOnClickListener(){
            if (view.tv_spefic_bus_line.visibility == View.VISIBLE){
                it.iv_spefic_bus_line_flod.setImageResource(R.drawable.freshman_necessary_fold_icon_up)
            } else {
                it.iv_spefic_bus_line_flod.setImageResource(R.drawable.freshman_necessary_fold_icon_down)
            }
        }
    }

}

