package com.mredrock.cyxbs.freshman.ui.fragment.data

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R

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

}
