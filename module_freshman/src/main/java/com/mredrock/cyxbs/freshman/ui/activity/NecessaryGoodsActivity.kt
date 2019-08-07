package com.mredrock.cyxbs.freshman.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.common.ui.BaseViewModelActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.FoldRecycleAdapter
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
import com.mredrock.cyxbs.freshman.utils.interfaces.OnCheckBoxClickListener
import com.mredrock.cyxbs.freshman.viewmodel.FoldBeanVm
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean
import kotlinx.android.synthetic.main.freshman_activity_necessary_goods.*
import kotlinx.android.synthetic.main.freshman_recycle_item_fold_check.view.*
import org.antlr.v4.runtime.misc.MurmurHash.finish
import java.util.ArrayList

class NecessaryGoodsActivity : BaseViewModelActivity<FoldBeanVm>() {
    override val isFragmentActivity: Boolean
        get() = false
    override val viewModelClass: Class<FoldBeanVm>
        get() = FoldBeanVm::class.java


    var datalist3 : List<FoldBean> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_necessary_goods)
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
        insert(null)

        //点击导航栏的返回图标，则返回上一个activity
        common_toolbar.init(title = "入学必备",
            listener = View.OnClickListener { v ->
                finish()
            })

        //报道必备
        val datalist1 = initData1()
        //军训用品
        val datalist2 = initData2()
        //备忘录
      //  val datalist3 = initData3()

        //悬浮按钮的点击事件
        fab_goto_edit_page.setOnClickListener { v ->

            val intent = Intent(this, EditMemoActivity::class.java)
            startActivity(intent)

        }



        //报道必备
        if (datalist1.size == 0) {
            tv_character_need_register.visibility = View.GONE
        }
        val adapter1 = FoldRecycleAdapter(this, datalist1, R.layout.freshman_recycle_item_fold_check)
        rv_need_register.layoutManager = LinearLayoutManager(this)
        rv_need_register.adapter = adapter1


        adapter1.setCheckBoxClickListener(object : OnCheckBoxClickListener {
            override fun OnClick(view: View, pos: Int) {

                //当item被选中之后，设置字体也变颜色
                if (view.cb_necessary_fold.isChecked) {
                    view.tv_necessary_thing.setTextColor(Color.parseColor("#d0d1d2"))
                } else {
                    view.tv_necessary_thing.setTextColor(Color.parseColor("#333333"))
                }
            }
        })


        //军训用品
        if (datalist2.size == 0) {
            tv_character_army_training_need.visibility = View.GONE
        }
        val adapter2 = FoldRecycleAdapter(context, datalist2, R.layout.freshman_recycle_item_fold_check)
        rv_need_army_training.layoutManager = LinearLayoutManager(this)
        rv_need_army_training.adapter = adapter2


        //备忘录
        if (datalist3.size == 0) {
            tv_character_memo.visibility = View.GONE
        }
        val adapter3 = FoldRecycleAdapter(context, datalist3, R.layout.freshman_recycle_item_fold_check)
        rv_need_unfogetable.layoutManager = LinearLayoutManager(this)
        rv_need_unfogetable.adapter = adapter3

        object : MyCallback<FoldBean> {
            override fun finished(beans: LiveData<List<FoldBean>>) {
                viewModel.beans.observe(this@NecessaryGoodsActivity, Observer<List<FoldBean>> {
                    (datalist3 as ArrayList).clear()
                    (datalist3 as ArrayList).addAll(it)
                    adapter3.notifyDataSetChanged()
                })
            }

        }

    }

    private fun initData1(): List<FoldBean> {
        val list = ArrayList<FoldBean>()
        val foldBean = FoldBean(
            "高考准考证", ""
        )
        for (i in 1..8) list.add(foldBean)

        return list
    }

    private fun initData2(): List<FoldBean> {
        val list = ArrayList<FoldBean>()
        val foldBean = FoldBean(
            "军训用品", """的方法烦烦烦的
            |芙蓉哥哥
            |鬼玩人果然有黄家驹解可看
            |今天一具体看jjt
            |纪迦太基
        """.trimMargin()
        )
        for (i in 1..8) list.add(foldBean)

        return list
    }

    private fun initData3(): List<FoldBean> {
        val list = ArrayList<FoldBean>()
        val foldBean = FoldBean(
            "备忘录", """的方法烦烦烦的
            |芙蓉哥哥
            |鬼玩人果然有黄家驹解可看
            |今天一具体看jjt
            |纪迦太基
        """.trimMargin()
        )
        for (i in 1..8) list.add(foldBean)

        return list
    }


    fun insert(view : View?){
        val foldBean = FoldBean(
            "备忘录", """的方法烦烦烦的
            |芙蓉哥哥
            |鬼玩人果然有黄家驹解可看
            |今天一具体看jjt
            |纪迦太基
        """.trimMargin()
        )
        for (i in 1..8) (datalist3 as ArrayList).add(foldBean)


    }


}
