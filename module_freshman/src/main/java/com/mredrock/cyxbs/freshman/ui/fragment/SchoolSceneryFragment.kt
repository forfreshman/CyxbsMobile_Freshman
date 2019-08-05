package com.mredrock.cyxbs.freshman.ui.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.activity.ShowPictureActivity
import com.mredrock.cyxbs.freshman.activity.ShowWayActivity
import com.mredrock.cyxbs.freshman.context.BaseFragment
import com.mredrock.cyxbs.freshman.ui.OnInitalRecycleIMClikListener
import com.mredrock.cyxbs.freshman.ui.adapter.SchoolSceneryRecycadapter
import com.mredrock.cyxbs.freshman.viewmodel.SchoolSceneryBean
import com.umeng.socialize.media.Base
import kotlinx.android.synthetic.main.freshman_activity_necessary_goods.*
import kotlinx.android.synthetic.main.freshman_fragment_school_scenery.*
import kotlinx.android.synthetic.main.freshman_recycle_item_scenery.*

/**
 *created by chenyang
 *on 2019/8/4
 */
class SchoolSceneryFragment : BaseFragment() {

    val list = ArrayList<SchoolSceneryBean>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialData()

        val recycleManager = GridLayoutManager(context, 2)
        val adapter = context?.let {
            SchoolSceneryRecycadapter(
                list as List<SchoolSceneryBean>,
                it,
                R.layout.freshman_recycle_item_scenery
            )
        }

        rv_school_scenery.layoutManager = recycleManager
        rv_school_scenery.adapter = adapter

        adapter?.setOnSchoolSceneryClikListener(object : OnSchoolSceneryClickListener {
            override fun OnCilick(position : Int, datas : List<SchoolSceneryBean>) {

                //小图片被点击以后执行全屏放大操作
                val intent = Intent(activity, ShowPictureActivity::class.java)
                val bundel = Bundle()
                bundel.putSerializable("dataList",list)
                bundel.putInt("clickedPicPos",position)
                intent.putExtra("dataBundel",bundel)
                startActivity(intent)

            }
        })

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_school_scenery, container, false)
        return view
    }


    private fun initialData() {
        val temp = SchoolSceneryBean("ddddd", "http://static.runoob.com/images/demo/demo1.jpg")
        for (i in 1..15) list.add(temp)
    }
}





