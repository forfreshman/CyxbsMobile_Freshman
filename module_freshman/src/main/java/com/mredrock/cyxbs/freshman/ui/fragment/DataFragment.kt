package com.mredrock.cyxbs.freshman.ui.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.DataRecylerviewAdapter
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DataViewModel
import android.content.Intent
import android.widget.Toast
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.ui.activity.DataActivity
import kotlinx.android.synthetic.main.freshman_data_fragment.*


class DataFragment : BaseFragment() {
    private val title = arrayListOf(
        "传媒艺术学院", "体育学院", "先进制造工程学院", "国际半导体学院", "国际学院"
        , "外国语学院", "现代邮政学院", "理学院", "生物信息学院", "经济管理学院", "网络信息安全与信息法学院", "自动化学院", "计算机科学与技术"
        , "软件工程学院", "通信与信息工程学院", "光电工程学院"
    )

    var adpter = DataRecylerviewAdapter(title)
    private var recyclerView: RecyclerView? = null



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
        initView()
        Log.d("begin:", "data")
    }


    private fun initView() {
        recyclerView = activity!!.findViewById<View>(R.id.rv_guide_data) as RecyclerView
        adpter.setOnItemClickListener(object : DataRecylerviewAdapter.OnItemClickListener {
            override fun onClick(position: Int, view: View) {
                val intent = Intent(activity, DataActivity::class.java)
                val bundle=Bundle()
                bundle.putInt("position",position)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun onLongClick(position: Int, view: View) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        rv_guide_data.adapter = adpter
        val linearLayoutManager = LinearLayoutManager(context)
        rv_guide_data.layoutManager = linearLayoutManager


    }

}

