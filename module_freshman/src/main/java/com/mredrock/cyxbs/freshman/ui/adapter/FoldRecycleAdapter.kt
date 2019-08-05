package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewmodel.FoldBean
import kotlinx.android.synthetic.main.freshman_recycle_item_fold.view.*

/**
 *created by chenyang
 *on 2019/8/3
 */

class FoldRecycleAdapter(val context: Context, val datas: List<FoldBean>) :
    RecyclerView.Adapter<FoldRecycleAdapter.MyViewHolder>() {

    //标记展开的item
    private var opened = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item_fold, parent, false)
        val holder = MyViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val bean = datas.get(position)
        holder.bindView(position, bean)

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bindView(position: Int, bean: FoldBean) {
//
//        }


        init {

            itemView.iv_necessary_fold.setOnClickListener { v ->

                if (opened == adapterPosition) {
                    //当前item已经被展开，关闭
                    opened = -1
                    notifyItemChanged(adapterPosition)
                } else {
                    val oldOpend = opened
                    opened = adapterPosition
                    notifyItemChanged(oldOpend)
                    notifyItemChanged(opened)
                }
            }


            itemView.cb_necessary_fold.setOnClickListener { v ->
                val view = v as CheckBox
                if (view.isChecked) {

                }
            }
        }

        fun bindView(pos: Int, bean: FoldBean) {

            itemView.tv_necessary_thing.setText(bean.mainMsg)
            itemView.tv_necessary_spefic.setText(bean.subMsg)

            if (pos == opened) {
                itemView.tv_necessary_spefic.visibility = View.VISIBLE
            } else {
                itemView.tv_necessary_spefic.visibility = View.GONE
            }
        }
    }
}