package com.mredrock.cyxbs.freshman.ui.fragment.delivery

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewmodel.fragment.SfViewModel

class SFFragment : Fragment() {

    companion object {
        fun newInstance() = SFFragment()
    }

    private lateinit var viewModel: SfViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freshman_sf_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SfViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
