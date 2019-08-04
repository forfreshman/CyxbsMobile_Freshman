package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mredrock.cyxbs.freshman.viewmodel.InitialPage

/**
 *created by chenyang
 *on 2019/8/2
 */

class InitialRecyclerView(
    private val context: Context, private val initialItems: List<InitialPage>,
    private val layoutInflater: LayoutInflater, private val layoutId: Int,
    private val variableId: Int
) : RecyclerView.Adapter<InitialRecyclerView.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setContent(initialItems.get(position))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        //先获得viewDataBinding对象， 这个对象中会持有条目item布局的引用
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        //只能用先获得viewDataBinding中view去实例化viewhoulder对象
        val viewHolder = ViewHolder(viewDataBinding.root.rootView)
        viewHolder.setBinding(viewDataBinding)
        return viewHolder

    }

    override fun getItemCount(): Int {
        return initialItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var viewDataBinding: ViewDataBinding? = null

        fun setBinding(viewDataBinding: ViewDataBinding?) {
            this.viewDataBinding = viewDataBinding
        }

        fun getBinding(): ViewDataBinding? {
            return viewDataBinding
        }

        fun setContent(t: InitialPage) {
            viewDataBinding!!.setVariable(variableId, t)

            viewDataBinding!!.executePendingBindings()
        }
    }
}
