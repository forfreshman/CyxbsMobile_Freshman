package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.DinningroomPageAdpter
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DiningroomViewModel
import kotlinx.android.synthetic.main.freshman_diningroom_fragment.*

class DiningroomFragment : Fragment() {
    private val title =object : ArrayList<String>(){
        init {
            this.add("千喜鹤")
            this.add("延生")
            this.add("红高粱")
            this.add("中心食堂")
            this.add("大西北")
        }
    }
    private var adapter :DinningroomPageAdpter?=null
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
        adapter= DinningroomPageAdpter(title,activity as Context)
        vp_guide_diningroom.adapter=adapter

    }

    private fun initTab(){
        tl_guide_diningroom.setupWithViewPager(vp_guide_diningroom)
        tl_guide_diningroom.setSelectedTabIndicatorHeight(0)
    }
}
