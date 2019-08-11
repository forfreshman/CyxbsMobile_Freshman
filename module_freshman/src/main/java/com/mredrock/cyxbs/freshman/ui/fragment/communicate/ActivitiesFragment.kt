package com.mredrock.cyxbs.freshman.ui.fragment.communicate

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.ActivityAdapter
import kotlinx.android.synthetic.main.freshman_copy_dialog.*
import kotlinx.android.synthetic.main.freshman_fragment_activities.*

class ActivitiesFragment : Fragment() {
    val activities= arrayListOf("学长学姐帮帮忙")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.freshman_fragment_activities, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adpter = context?.let { ActivityAdapter(activities, it) }
        val linerLayoutManager = LinearLayoutManager(context)
        rv_communicate_activity.adapter = adpter
        rv_communicate_activity.layoutManager = linerLayoutManager
    }
}
