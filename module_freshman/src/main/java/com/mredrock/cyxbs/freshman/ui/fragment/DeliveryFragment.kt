package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.DeliveryPageAdapter
import com.mredrock.cyxbs.freshman.ui.adapter.HostelPageAdpter
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DeliveryViewModel
import kotlinx.android.synthetic.main.freshman_delivery_fragment.*

class DeliveryFragment : BaseFragment() {

    private val title =object : ArrayList<String>(){
        init {
            this.add("顺丰")
            this.add("韵达")
            this.add("中通")
            this.add("圆通")
            this.add("申通")
            this.add("邮政/EMS")
            this.add("菜鸟驿站（校外）")
            this.add("百世")
        }
    }
    private var adapter: DeliveryPageAdapter?=null
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
        adapter= DeliveryPageAdapter(title,activity as Context)
        adapter!!.initView()
        vp_guide_delivery.adapter=adapter
    }


    private fun initTab(){
        tl_guide_delivery.setupWithViewPager(vp_guide_delivery)
        tl_guide_delivery.tabMode=TabLayout.MODE_SCROLLABLE
        tl_guide_delivery.setSelectedTabIndicatorHeight(0)
    }
}
