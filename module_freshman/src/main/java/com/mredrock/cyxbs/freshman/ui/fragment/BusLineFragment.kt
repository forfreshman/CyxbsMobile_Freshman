package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.db.repository.BusLineRepository
import com.mredrock.cyxbs.freshman.ui.adapter.BusLineRecycleAdapter
import com.mredrock.cyxbs.freshman.viewmodel.BusLineBeanVM
import com.mredrock.cyxbs.freshman.viewmodel.bean.BusLineBean
import kotlinx.android.synthetic.main.freshman_fragment_bus_line.*

/**
 *created by chenyang
 *on 2019/8/4
 */

class BusLineFragment : BaseViewModelFragment<BusLineBeanVM>() {
    override val viewModelClass: Class<BusLineBeanVM>
        get() = BusLineBeanVM::class.java

    private val beans = ArrayList<BusLineBean>()
    private val repository = BusLineRepository()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_bus_line, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialData()

        val manager = LinearLayoutManager(context)
        val adapter = context?.let { BusLineRecycleAdapter(beans, it, R.layout.freshman_recycle_item_bus_line) }

        rv_bus_lines.layoutManager = manager
        rv_bus_lines.adapter = adapter

        setviewModel(adapter)

        viewModel = ViewModelProviders.of(this).get(viewModelClass)
        viewModel


        tv_copy_school_address.setOnClickListener { v ->

            /*点击复制文字后，将大学地址复制到剪贴板，并弹出Toast提醒用户*/
            //获取剪贴板
            val clipBoard = context?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            //第一个参数为tag
            val clip = ClipData.newPlainText("SchoolAddress", tv_spefic_school_address.text)
            clipBoard.primaryClip = clip


            Toast.makeText(context, R.string.freshman_fragment_bus_line_copied, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setviewModel( adapter: BusLineRecycleAdapter?) {

        viewModel = ViewModelProviders.of(this).get(viewModelClass)
        viewModel.beans?.observe ( this@BusLineFragment, Observer<List<BusLineBean>> {
            beans.clear()
            beans.addAll(it)
            adapter?.notifyDataSetChanged()
        } )

    }



    private fun initialData() {
        val id = 0
        val temp = BusLineBean(
            id ,"重庆北站", """灌灌灌灌-》
            |会你可还好
            |讲究迥异哈哈
            |哪里会你看哈
        """.trimMargin()
        )
        for (i in 1..15) {
            ++temp.id
            beans.add(temp)
        }
    }
}