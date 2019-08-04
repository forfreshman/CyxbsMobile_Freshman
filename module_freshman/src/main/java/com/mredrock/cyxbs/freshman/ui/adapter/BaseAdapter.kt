package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.common.utils.LogUtils


/**
 * created by chenyang
 * on 2019/8/4
 */
abstract class BaseAdapter<T> internal constructor(private val datas: List<T>, private val context: Context) :
    RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    internal abstract val latoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val view = LayoutInflater.from(context).inflate(latoutId, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        creatHolder(holder, datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }

      class BaseViewHolder(itemViews: View) : RecyclerView.ViewHolder(itemViews){
         fun getView() : View{
             return itemView
         }

      }

    internal abstract fun creatHolder(holder: BaseViewHolder, t: T)

}
