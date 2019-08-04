package com.mredrock.cyxbs.freshman.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.context.BaseFragment
import com.mredrock.cyxbs.freshman.ui.adapter.DataRecylerviewAdapter
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DataViewModel
import android.content.Intent
import com.mredrock.cyxbs.freshman.activity.DataActivity


class DataFragment : BaseFragment() {
    private val title =ArrayList<String>()
    private var recyclerView :RecyclerView?=null

    companion object {
        fun newInstance() = DataFragment()
    }

    private lateinit var viewModel: DataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freshman_data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
        Log.d("begin:","data")
    }

    private fun initData(){
        title.add("传媒艺术学院")
        title.add("生物信息学院")
        title.add("自动化学院")
        title.add("先进制造工程学院")
        title.add("软件工程学院")
        title.add("外国语学院")
        title.add("马克思主义学院")
        title.add("网络信息安全与信息法学院")
    }

    private fun initView(){
        recyclerView=activity!!.findViewById<View>(R.id.rv_guide_data) as RecyclerView
        val adpter :DataRecylerviewAdapter= DataRecylerviewAdapter(title)
        adpter.setOnItemClickListener(object :DataRecylerviewAdapter.OnItemClickListener{
            override fun onClick(position: Int, view: View) {
                val intent = Intent(activity, DataActivity::class.java)
                startActivity(intent)
            }

            override fun onLongClick(position: Int, view: View) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }



        })
        recyclerView!!.adapter=adpter
        val linearLayoutManager=LinearLayoutManager(context)
        recyclerView!!.layoutManager=linearLayoutManager
    }
}
