package com.mredrock.cyxbs.freshman.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.MyPageAdpter
import com.mredrock.cyxbs.freshman.ui.fragment.delivery.*
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DeliveryViewModel

class DeliveryFragment : BaseFragment() {
    private var  tabLayout : TabLayout?=null
    private var deliveryViewpager:ViewPager?=null
    private val deliveryFragments=ArrayList<Fragment>()
    private val title =ArrayList<String>()
    private var adapter: MyPageAdpter?=null
    private var mView :View?=null


    companion object {
        fun newInstance() = DeliveryFragment()
    }

    private lateinit var viewModel: DeliveryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.freshman_delivery_fragment, container, false)
        return mView;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("begin:","delivery")
        initData()
        initTab()
    }

    private fun initData(){
        title.add("顺丰")
        title.add("韵达")
        title.add("中通")
        title.add("圆通")
        title.add("申通")
        title.add("邮政/EMS")
        title.add("菜鸟驿站（校外）")
        title.add("百世")
        deliveryFragments.add(SFFragment())
        deliveryFragments.add(YDFragment())
        deliveryFragments.add(ZtFragment())
        deliveryFragments.add(YTFragment())
        deliveryFragments.add(STFragment())
        deliveryFragments.add(EMSFragment())
        deliveryFragments.add(CNYZFragment())
        deliveryFragments.add(BSFragment())
        adapter=MyPageAdpter(childFragmentManager,deliveryFragments,title)
        deliveryViewpager=activity!!.findViewById<View>(R.id.vp_guide_delivery) as ViewPager
        deliveryViewpager!!.adapter=adapter
    }


    private fun initTab(){
        tabLayout=activity!!.findViewById<View>(R.id.tl_guide_delivery) as TabLayout
        tabLayout!!.setupWithViewPager(deliveryViewpager)
        tabLayout!!.tabMode=TabLayout.MODE_SCROLLABLE
        tabLayout!!.setSelectedTabIndicatorHeight(0)
    }
}
