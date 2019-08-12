package com.mredrock.cyxbs.freshman.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.R


class DataRecylerviewAdapter(internal var title: List<String>) :
    RecyclerView.Adapter<DataRecylerviewAdapter.ViewHolder>() {
    private var mOnItemClickListener: OnItemClickListener? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.freshman_recyle_item_guide_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = title[position]
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener { v -> mOnItemClickListener!!.onClick(position, v) }

            holder.itemView.setOnLongClickListener { v ->
                mOnItemClickListener!!.onLongClick(position, v)
                false
            }
        }
    }

    override fun getItemCount(): Int {
        return title.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var textView: TextView

        init {
            textView = itemView.findViewById<View>(R.id.tv_guide_data) as TextView
        }
    }

    interface OnItemClickListener {
        fun onClick(position: Int, view: View)
        fun onLongClick(position: Int, view: View)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

}
