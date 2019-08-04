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
import com.mredrock.cyxbs.freshman.ui.fragment.hostel.MLYFragment
import com.mredrock.cyxbs.freshman.ui.fragment.hostel.NJYFragment
import com.mredrock.cyxbs.freshman.ui.fragment.hostel.XYYFragment
import com.mredrock.cyxbs.freshman.ui.fragment.hostel.ZXYFragment
import com.mredrock.cyxbs.freshman.viewmodel.fragment.HostelViewModel
import kotlin.math.log


class HostelFragment : Fragment() {
    private var  tabLayout : TabLayout?=null
    private var hostelViewpager: ViewPager?=null
    private val hostelFragments=ArrayList<Fragment>()
    private val title =ArrayList<String>()
    private var adapter: MyPageAdpter?=null
    private var mView :View?=null

    companion object {
        fun newInstance() = HostelFragment()
    }

    private lateinit var viewModel: HostelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.freshman_hostel_fragment, container, false)
        return mView;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initTab()
        Log.d("begin:","hostel")
    }

    private fun initData(){
        title.add("知行苑")
        title.add("明理苑")
        title.add("宁静苑")
        title.add("兴业苑")
        hostelFragments.add(ZXYFragment.newInstance())
        hostelFragments.add(MLYFragment.newInstance())
        hostelFragments.add(NJYFragment.newInstance())
        hostelFragments.add(XYYFragment.newInstance())
        adapter=MyPageAdpter(childFragmentManager,hostelFragments,title)
        hostelViewpager=activity!!.findViewById<View>(R.id.vp_guide_hostel) as ViewPager
        hostelViewpager!!.adapter=adapter
    }

    private fun initTab(){
        tabLayout=activity!!.findViewById<View>(R.id.tl_guide_hostel) as TabLayout
        tabLayout!!.setupWithViewPager(hostelViewpager)
        tabLayout!!.setSelectedTabIndicatorHeight(0)

    }


}
