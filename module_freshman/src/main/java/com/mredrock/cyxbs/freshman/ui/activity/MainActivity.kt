package com.mredrock.cyxbs.freshman.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.utils.interfaces.OnInitalRecycleIMClikListener
import com.mredrock.cyxbs.common.utils.LogUtils
import com.mredrock.cyxbs.freshman.R

import com.mredrock.cyxbs.freshman.ui.adapter.InitialRecycleAdapter
import com.mredrock.cyxbs.freshman.viewmodel.InitialItemBeanVM
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean
import kotlinx.android.synthetic.main.freshman_activity_main.*
import kotlin.collections.ArrayList

class MainActivity : BaseViewModelActivity<InitialItemBeanVM>() {
    override val isFragmentActivity: Boolean
        get() = false
    override val viewModelClass: Class<InitialItemBeanVM>
        get() = InitialItemBeanVM::class.java

    val dataList = ArrayList<InitialItemBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_main)
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
        val initialRecyclerViewAdapter = InitialRecycleAdapter(application, dataList as List<InitialItemBean>)

        insert(null)
//        setviewModel(initialRecyclerViewAdapter)


        initialRecyclerViewAdapter.setItemOnclicListener(object :
            OnInitalRecycleIMClikListener {

            //主页右侧的箭头，点击之后，会跳转到相应的页面
            override fun OnCilick(mainTitle: String?) {
                var intent: Intent? = null
                when (mainTitle) {
                    "入学必备" ->
                        intent = Intent(context, NecessaryGoodsActivity::class.java)
                    "指路重邮" ->
                        intent = Intent(context, ShowWayActivity::class.java)
                    "入学流程" ->
                        intent = Intent(context, AdmissionProcessActivity::class.java)
//                        LogUtils.d("","")
                    "校园指导" ->
                        intent = Intent(context, GuideActivity::class.java)
                    "线上活动" -> LogUtils.d("", "")
                    "更多功能" ->
                        intent = Intent(context,MoreFunctionActivity ::class.java)
                    "关于我们" -> LogUtils.d("", "")
                }
                startActivity(intent)
            }

        })


        rv_initial_page.layoutManager = LinearLayoutManager(this)
        rv_initial_page.adapter = initialRecyclerViewAdapter


    }

//    private fun setviewModel(adapter : InitialRecycleAdapter) {
//        viewModel.beans.observe(this@MainActivity, Observer<List<InitialItemBean>> {
//            dataList.clear()
//            dataList.addAll(it)
//            adapter.notifyDataSetChanged()
//        })
//
//    }


    fun insert(view: View?) {
        var id = 0
        val one = InitialItemBean(++id, "入学必备", "报道必备 宿舍用品 学习用品")
        viewModel.insertInitialItemBean(one)
        val two = InitialItemBean(++id, "指路重邮", "重游路线 重邮地图")
        viewModel.insertInitialItemBean(two)
        val three = InitialItemBean(++id, "入学流程", "入学步骤 入学地点")
        viewModel.insertInitialItemBean(three)
        val four = InitialItemBean(++id, "校园指导", "校舍 快递点指引")
        viewModel.insertInitialItemBean(four)
        val five = InitialItemBean(++id, "线上活动", "校舍 快递点指引")
        viewModel.insertInitialItemBean(five)
        val six = InitialItemBean(++id, "更多功能", "迎新网 新生课表")
        viewModel.insertInitialItemBean(six)
        val seven = InitialItemBean(++id, "关于我们", "红岩网校")
        viewModel.insertInitialItemBean(seven)

    }


    fun query(view: View) {
//        List<User> allUser = mRepository.getAllUser();
//        mUsers.addAll(allUser);
//        mAdapter.notifyDataSetChanged();
    }

    fun deleteAll(view: View) {
        viewModel.deletAll()
    }

    fun update(view: View) {
    //    val seven = InitialItemBean(++id,"关于我们", "红岩网校")

   //     viewModel.updata();
    }



}
