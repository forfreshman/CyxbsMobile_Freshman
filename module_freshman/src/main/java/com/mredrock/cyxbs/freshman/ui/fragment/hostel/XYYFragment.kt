package com.mredrock.cyxbs.freshman.ui.fragment.hostel

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewmodel.fragment.XyyViewModel

class XYYFragment : Fragment() {

    companion object {
        fun newInstance() = XYYFragment()
    }

    private lateinit var viewModel: XyyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freshman_xyy_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(XyyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
