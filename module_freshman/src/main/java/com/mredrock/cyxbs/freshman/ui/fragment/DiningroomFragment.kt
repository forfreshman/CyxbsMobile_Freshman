package com.mredrock.cyxbs.freshman.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.MyPageAdpter
import com.mredrock.cyxbs.freshman.ui.fragment.diningroom.*
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DiningroomViewModel

class DiningroomFragment : Fragment() {
    private var  tabLayout : TabLayout?=null
    private var dinningViewpager: ViewPager?=null
    private val diningFragments=ArrayList<Fragment>()
    private val title =ArrayList<String>()
    private var adapter :MyPageAdpter?=null
    private var mView :View?=null

    companion object {
        fun newInstance() = DiningroomFragment()
    }

    private lateinit var viewModel: DiningroomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.freshman_diningroom_fragment, container, false)
        return mView;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initTab()
        Log.d("begin:","dinning")
    }

    private fun initData(){
        title.add("千喜鹤")
        title.add("延生")
        title.add("红高粱")
        title.add("中心食堂")
        title.add("大西北")
        diningFragments.add(QXHFragment.newInstance())
        diningFragments.add(YSFragment.newInstance())
        diningFragments.add(HGLFragment.newInstance())
        diningFragments.add(ZXSTFragment.newInstance())
        diningFragments.add(DXBFragment.newInstance())
        dinningViewpager=activity!!.findViewById<View>(R.id.vp_guide_diningroom) as ViewPager
        adapter=MyPageAdpter(childFragmentManager,diningFragments,title)
        dinningViewpager!!.adapter=adapter
    }

    private fun initTab(){
        tabLayout=activity!!.findViewById<View>(R.id.tl_guide_diningroom) as TabLayout
        tabLayout!!.setupWithViewPager(dinningViewpager)
        tabLayout!!.setSelectedTabIndicatorHeight(0)
    }
}
