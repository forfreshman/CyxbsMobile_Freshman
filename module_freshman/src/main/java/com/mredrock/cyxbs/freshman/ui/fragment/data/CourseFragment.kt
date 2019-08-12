package com.mredrock.cyxbs.freshman.ui.fragment.data

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.activity.DataActivity
import com.mredrock.cyxbs.freshman.ui.adapter.DataRecylerviewAdapter
import com.mredrock.cyxbs.freshman.ui.fragment.DataFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DiningroomFragment
import kotlinx.android.synthetic.main.freshman_course_fragment.*
import kotlinx.android.synthetic.main.freshman_dialog_communicate.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.support.v4.runOnUiThread
import org.json.JSONObject

class CourseFragment : Fragment() {



    companion object {
        fun newInstance() = CourseFragment()
    }

    private lateinit var viewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freshman_course_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CourseViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}
