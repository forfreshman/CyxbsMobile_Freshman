package com.mredrock.cyxbs.freshman.ui.fragment.data

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.weight.FreshmanPieView
import kotlinx.android.synthetic.main.freshman_percent_fragment.*

class PercentFragment : Fragment() {

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
        pieview_data.setTitle("自动化学院")
        pieview_data.setMalePercent(90.1)
        pieview_data.setFemalePercent(9.9)
    }
}
