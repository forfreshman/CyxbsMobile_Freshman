package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.utils.interfaces.OnCheckBoxClickListener
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import kotlinx.android.synthetic.main.freshman_recycle_item_fold_check.view.*

/**
 *created by chenyang
 *on 2019/8/3
 */
class FoldRecycleAdapter(val context: Context, val datas: List<FoldBean>, val layoutId :Int) :
    RecyclerView.Adapter<FoldRecycleAdapter.MyViewHolder>() {

    private var checkBoxClickListener : OnCheckBoxClickListener ?= null
    //标记展开的item
    private var opened = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
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

        if(holder.itemView.tv_necessary_spefic.visibility == View.VISIBLE){
            holder.itemView.iv_necessary_fold.setImageResource(R.drawable.freshman_necessary_fold_icon_up)
        }

    }

    fun setCheckBoxClickListener(onCheckBoxClickListener: OnCheckBoxClickListener){

        checkBoxClickListener = onCheckBoxClickListener
    }


    inner class MyViewHolder(itemViews: View) : RecyclerView.ViewHolder(itemViews) {


        init {

            itemViews.tv_click.setOnClickListener { v ->

                if(itemView.tv_necessary_spefic.visibility == View.VISIBLE){
                    itemViews.iv_necessary_fold.setImageResource(R.drawable.freshman_necessary_fold_icon_up)
                }else{
                    itemViews.iv_necessary_fold.setImageResource(R.drawable.freshman_necessary_fold_icon_down)
                }
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


//            itemView.cb_necessary_fold.setOnClickListener { v ->
//                val view = v as CheckBox
//                if (view.isChecked) {
//
//                }
//            }
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