package com.mredrock.cyxbs.freshman.ui.fragment.data

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.weight.FreshmanPieView

class PercentFragment : Fragment() {
    private var pieView :FreshmanPieView?=null

    companion object {
        fun newInstance() = PercentFragment()
    }

    private lateinit var viewModel: PercentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freshman_percent_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PercentViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pieView=activity!!.findViewById<View>(R.id.pieview_data) as FreshmanPieView
        pieView!!.setTitle("软件学院")
        pieView!!.setMalePercent(80)
        pieView!!.setFemalePercent(20)
    }
}
