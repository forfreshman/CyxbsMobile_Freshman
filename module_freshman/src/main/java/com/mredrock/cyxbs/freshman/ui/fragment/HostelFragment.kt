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
import kotlinx.android.synthetic.main.freshman_hostel_fragment.*
import kotlin.math.log


class HostelFragment : Fragment() {
    private val hostelFragments=object : ArrayList<Fragment>(){
        init {
            this.add(ZXYFragment.newInstance())
            this.add(MLYFragment.newInstance())
            this.add(NJYFragment.newInstance())
            this.add(XYYFragment.newInstance())
        }
    }
    private var title =object : ArrayList<String>(){
        init {
            this.add("知行苑")
            this.add("明理苑")
            this.add("宁静苑")
            this.add("兴业苑")
        }
    }
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
        adapter=MyPageAdpter(childFragmentManager,hostelFragments,title)
        vp_guide_hostel.adapter=adapter
    }

    private fun initTab(){
        tl_guide_hostel.setupWithViewPager(vp_guide_hostel)
        tl_guide_hostel.setSelectedTabIndicatorHeight(0)

    }


}
