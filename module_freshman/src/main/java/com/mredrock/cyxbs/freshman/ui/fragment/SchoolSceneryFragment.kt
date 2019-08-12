package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.ShowPictureActivity
import com.mredrock.cyxbs.freshman.ui.adapter.SchoolSceneryRecycadapter
import com.mredrock.cyxbs.freshman.utils.interfaces.OnSchoolSceneryClickListener
import com.mredrock.cyxbs.freshman.viewmodel.bean.SchoolSceneryBean
import kotlinx.android.synthetic.main.freshman_fragment_school_scenery.*

/**
 *created by chenyang
 *on 2019/8/4
 */

class SchoolSceneryFragment : BaseFragment() {

    val list = ArrayList<SchoolSceneryBean>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

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

        adapter?.setOnSchoolSceneryClikListener(object :
            OnSchoolSceneryClickListener {
            override fun OnCilick(position: Int, datas: List<SchoolSceneryBean>) {

                //小图片被点击以后执行全屏放大操作
                val intent = Intent(activity, ShowPictureActivity::class.java)
                val bundel = Bundle()
                bundel.putSerializable("dataList", list)
                bundel.putInt("clickedPicPos", position)
                intent.putExtra("dataBundel", bundel)
                startActivity(intent)

            }
        })


    }
}






