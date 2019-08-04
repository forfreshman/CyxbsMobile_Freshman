package com.mredrock.cyxbs.freshman.ui.fragment.delivery

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewmodel.fragment.YdViewModel

class YDFragment : Fragment() {

    companion object {
        fun newInstance() = YDFragment()
    }

    private lateinit var viewModel: YdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freshman_yd_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(YdViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
