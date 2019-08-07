package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.utils.interfaces.OnInitalRecycleIMClikListener
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean
import kotlinx.android.synthetic.main.freshman_recycle_item_initial.view.*

/**
 *created by chenyang
 *on 2019/8/2
 */

class InitialRecycleAdapter(private val context: Context, private val initialItems: List<InitialItemBean>) :
    RecyclerView.Adapter<InitialRecycleAdapter.ViewHolder>() {


    private var listener: OnInitalRecycleIMClikListener? = null


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val initialItem = initialItems.get(position)
        holder.getView().tv_initial_first.setText(initialItem.mainTitle)
        holder.getView().tv_initial_second.setText(initialItem.subhead)

        holder.getView().setOnClickListener { v ->

            listener?.OnCilick(initialItem.mainTitle)
        }

    }

    fun setItemOnclicListener(listener: OnInitalRecycleIMClikListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.freshman_recycle_item_initial, parent, false)
        val viewHolder = ViewHolder(view)

        return viewHolder

    }

    override fun getItemCount(): Int {
        return initialItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun getView(): View {
            return itemView
        }
    }

}
