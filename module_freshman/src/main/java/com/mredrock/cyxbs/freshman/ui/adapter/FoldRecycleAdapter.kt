package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.utils.interfaces.OnCheckBoxClickListener
import com.mredrock.cyxbs.freshman.viewmodel.FoldBean
import kotlinx.android.synthetic.main.freshman_recycle_item_edit_memo.view.*
import kotlinx.android.synthetic.main.freshman_recycle_item_fold.view.*


/**
 *created by chenyang
 *on 2019/8/3
 */

class FoldRecycleAdapter(val context: Context, val datas: List<FoldBean>) :
    RecyclerView.Adapter<FoldRecycleAdapter.MyViewHolder>() {

    //标记展开的item
    private var opened = -1
    private var checkBoxClickListener:OnCheckBoxClickListener?=null


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
        //当CheckBox被点击以后
        holder.itemView.cb_necessary_fold.setOnClickListener{v ->
            checkBoxClickListener?.OnClick(holder.itemView, position)

        }

        if (holder.itemView.tv_necessary_spefic.text == "") {
            holder.itemView.iv_necessary_fold.visibility = View.GONE
        }
    }

    fun setCheckBoxClickListener(onCheckBoxClickListener: OnCheckBoxClickListener){

        checkBoxClickListener = onCheckBoxClickListener

    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

            itemView.iv_msg_flod.setOnClickListener { v ->

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


            itemView.cb_fold.setOnClickListener { v ->
                val view = v as CheckBox
                if (view.isChecked) {

                }
            }
        }

        fun bindView(pos: Int, bean: FoldBean) {

            itemView.tv_msg_main.setText(bean.mainMsg)
            itemView.tv_msg_sub.setText(bean.subMsg)

            if (pos == opened) {
                itemView.tv_msg_sub.visibility = View.VISIBLE
            } else {
                itemView.tv_msg_sub.visibility = View.GONE
            }
        }
    }
}