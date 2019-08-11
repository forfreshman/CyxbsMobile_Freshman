package com.mredrock.cyxbs.freshman.ui.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.AdmissionProcessAdapter
import com.mredrock.cyxbs.freshman.viewmodel.AdmissionProcessBeanVM
import com.mredrock.cyxbs.freshman.viewmodel.bean.AdmissionProcessBean
import kotlinx.android.synthetic.main.freshman_activity_admission_process.*

class AdmissionProcessActivity : BaseViewModelActivity<AdmissionProcessBeanVM>() {
    override val isFragmentActivity: Boolean
        get() = false
    override val viewModelClass: Class<AdmissionProcessBeanVM>
        get() = AdmissionProcessBeanVM::class.java

    var dataList = ArrayList<AdmissionProcessBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_admission_process)

        insert()

        viewModel = ViewModelProviders.of(this).get()
        val adapter = AdmissionProcessAdapter(this, dataList, R.layout.freshman_recycle_item_process)
        rv_admission_process.layoutManager = LinearLayoutManager(this)
        rv_admission_process.adapter = adapter

        viewModel.beans?.observe(this@AdmissionProcessActivity, Observer {
            dataList.clear()
            dataList.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }

    fun insert() {
        for (i in 0..10) {
            val bean = AdmissionProcessBean()
            bean.title = "持相关证件至风雨操场各学院报道"
            bean.detail = """太极
            |帆帆帆帆帆帆帆帆帆帆
            |丰富呃呃呃呃呃呃呃
            |给哈哈哈哈哈哈哈
            |灌灌灌灌
        """.trimMargin()
            bean.photo = "dddd"

            bean.id = i

            viewModel.insertAdmissionProcessBean(bean)
        }
    }

}
