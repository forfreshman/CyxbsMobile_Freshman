package com.mredrock.cyxbs.freshman.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.SchoolSceneryRecycadapter
import com.mredrock.cyxbs.freshman.viewmodel.SchoolSceneryBean
import kotlinx.android.synthetic.main.freshman_activity_necessary_goods.*
import kotlinx.android.synthetic.main.freshman_fragment_school_scenery.*

/**
 *created by chenyang
 *on 2019/8/4
 */
class SchoolSceneryFragment : Fragment(){

    val list = ArrayList<SchoolSceneryBean>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialData()

        val recycleManager = GridLayoutManager(context, 2)
        val adapter = context?.let { SchoolSceneryRecycadapter(list as List<SchoolSceneryBean>, it,R.layout.freshman_recycle_item_scenery) }

            rv_school_scenery.layoutManager = recycleManager
            rv_school_scenery.adapter = adapter
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_school_scenery, container, false)
        return view
    }



    private fun initialData() {
        val temp = SchoolSceneryBean("ddddd","http://static.runoob.com/images/demo/demo1.jpg")
        for (i in 1..15) list.add(temp)
    }
}





