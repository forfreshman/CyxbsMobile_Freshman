package com.mredrock.cyxbs.freshman.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import kotlinx.android.synthetic.main.freshman_fragment_add_memo_item.view.*

/**
 *created by chenyang
 *on 2019/8/6
 */
class AddMemoItemFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_add_memo_item, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val inputString = view.et_add_memo_item.toString()
    }

}