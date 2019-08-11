package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.viewmodel.SchoolSceneryBean
import kotlinx.android.synthetic.main.freshman_recycle_item_scenery.view.*

/**
 *created by chenyang
 *on 2019/8/4
 */
class SchoolSceneryRecycadapter(datas: List<SchoolSceneryBean>, val context: Context,
                                override val latoutId: Int) :
    BaseAdapter<SchoolSceneryBean>(datas, context) {


    override fun creatHolder(holder: BaseViewHolder, t: SchoolSceneryBean) {
       val image = holder.getView().iv_school_scenery_small
        val textView = holder.getView().tv_scenery_name

        Glide.with(context).load(t.sceneryImgeurl).into(image)
        textView.setText(t.sceneryName)


    }

}