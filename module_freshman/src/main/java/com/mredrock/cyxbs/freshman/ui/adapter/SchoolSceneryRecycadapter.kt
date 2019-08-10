package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.utils.interfaces.OnSchoolSceneryClickListener
import com.mredrock.cyxbs.freshman.viewmodel.bean.SchoolSceneryBean
import kotlinx.android.synthetic.main.freshman_recycle_item_scenery.view.*
import kotlinx.android.synthetic.main.freshman_recycle_item_scenery.view.iv_school_scenery_small

/**
 *created by chenyang
 *on 2019/8/4
 */
class SchoolSceneryRecycadapter(
    val datas: List<SchoolSceneryBean>, val context: Context,
    override val latoutId: Int
) :
    BaseAdapter<SchoolSceneryBean>(datas, context) {

    private var listener: OnSchoolSceneryClickListener? = null


    override fun creatHolder(holder: BaseViewHolder, t: SchoolSceneryBean) {
        val image = holder.getView().iv_school_scenery_small
        val textView = holder.getView().tv_scenery_name
        val position = datas.indexOf(t)

//        Glide.with(context).load(t.sceneryImgeurl).into(image)
        Glide.with(context).load(R.drawable.aaaaaaaaa).into(image)
        textView.setText(t.sceneryName)

        //校园风景图小图片被点击之后
        image.setOnClickListener { v ->

            listener?.OnCilick(position, datas)

        }
    }

    fun setOnSchoolSceneryClikListener(listener: OnSchoolSceneryClickListener) {

        this.listener = listener
    }

}