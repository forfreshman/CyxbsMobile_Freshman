package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.HostelPageAdpter
import com.mredrock.cyxbs.freshman.viewmodel.fragment.HostelViewModel
import kotlinx.android.synthetic.main.freshman_hostel_fragment.*


class HostelFragment : Fragment() {

    private var title =object : ArrayList<String>(){
        init {
            this.add("知行苑")
            this.add("明理苑")
            this.add("宁静苑")
            this.add("兴业苑")
        }
    }
    private var adapter: HostelPageAdpter?=null
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
        adapter=HostelPageAdpter(title,activity as Context)
        vp_guide_hostel.adapter=adapter
    }

    private fun initTab(){
        tl_guide_hostel.setupWithViewPager(vp_guide_hostel)
        tl_guide_hostel.setSelectedTabIndicatorHeight(0)

    }


}
