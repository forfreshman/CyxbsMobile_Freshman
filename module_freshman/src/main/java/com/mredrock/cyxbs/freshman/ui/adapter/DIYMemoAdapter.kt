package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.View
import com.mredrock.cyxbs.freshman.utils.interfaces.OnCheckBoxClickListener
import com.mredrock.cyxbs.freshman.viewmodel.bean.DIYMemoBean
import kotlinx.android.synthetic.main.freshman_recycle_item_edit_memo.view.*
import kotlinx.android.synthetic.main.freshman_recycle_item_edit_memo.view.cb_necessary_fold
import kotlinx.android.synthetic.main.freshman_recycle_item_edit_memo.view.iv_necessary_fold
import kotlinx.android.synthetic.main.freshman_recycle_item_edit_memo.view.tv_necessary_spefic

/**
 *created by chenyang
 *on 2019/8/10
 */
class DIYMemoAdapter(val context: Context, val datas: List<DIYMemoBean>,
                     override val latoutId: Int) : BaseAdapter<DIYMemoBean>(datas, context) {

    private var checkBoxClickListener : OnCheckBoxClickListener?= null


    override fun creatHolder(holder: BaseViewHolder, t: DIYMemoBean) {
        val view = holder.getView()
        val position = datas.indexOf(t)

        holder.itemView.tv_diy_necessary_thing.setText(t.DIYMemo)
        view.iv_necessary_fold.visibility = View.GONE
        view.tv_necessary_spefic.visibility = View.GONE

        //当CheckBox被点击以后
        holder.itemView.cb_necessary_fold.setOnClickListener{v ->
            checkBoxClickListener?.OnClick(holder.itemView, position)
        }


    }
    fun setCheckBoxClickListener(onCheckBoxClickListener: OnCheckBoxClickListener){

        checkBoxClickListener = onCheckBoxClickListener
    }


}