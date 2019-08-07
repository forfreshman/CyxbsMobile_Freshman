package com.mredrock.cyxbs.freshman.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.FoldRecycleAdapter
import com.mredrock.cyxbs.freshman.utils.interfaces.OnCheckBoxClickListener
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import kotlinx.android.synthetic.main.freshman_fragment_edit_memo_item.*
import kotlinx.android.synthetic.main.freshman_fragment_edit_memo_item.view.*
import java.util.ArrayList

/**
 *created by chenyang
 *on 2019/8/6
 */

class EditMemoItemFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_edit_memo_item, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val dataList = initData()
        if (dataList.size == 0) {
            view.tv_hint_no_memo.visibility = View.VISIBLE
            view.tv_hint_bg_memo.visibility = View.GONE
        }else{
            view.tv_hint_no_memo.visibility = View.GONE
        }

        val adapter = context?.let { FoldRecycleAdapter(it, dataList, R.layout.freshman_recycle_item_edit_memo) }
        rv_editable_unforgetable.layoutManager = LinearLayoutManager(context)
        rv_editable_unforgetable.adapter = adapter


        /**
         * 当box被选中之后，说明有可能被删除,通过这里可以统计被选中的item
         */
        adapter?.setCheckBoxClickListener(object : OnCheckBoxClickListener{
            override fun OnClick(view: View, pos: Int) {
                //这里传进来的view时是总的view


            }
        })

    }


    //该方法专为模拟备忘录有东西而设置(后面有数据库之后即可删除)
    private fun initData(): List<FoldBean> {
        val list = ArrayList<FoldBean>()
        val foldBean = FoldBean(
            "备忘录的东西", """的方法烦烦烦的
            |芙蓉哥哥
            |鬼玩人果然有黄家驹解可看
            |今天一具体看jjt
            |纪迦太基
        """.trimMargin()
        )
        for (i in 1..15) list.add(foldBean)

        return list
    }

}