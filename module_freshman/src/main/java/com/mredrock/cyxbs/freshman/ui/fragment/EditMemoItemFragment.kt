package com.mredrock.cyxbs.freshman.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.DIYMemoAdapter
import com.mredrock.cyxbs.freshman.utils.interfaces.DIYMemoClicklistener
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
import com.mredrock.cyxbs.freshman.utils.interfaces.OnCheckBoxClickListener
import com.mredrock.cyxbs.freshman.viewmodel.DIYMemoBeanVM
import com.mredrock.cyxbs.freshman.viewmodel.bean.DIYMemoBean
import kotlinx.android.synthetic.main.freshman_fragment_edit_memo_item.*
import kotlinx.android.synthetic.main.freshman_fragment_edit_memo_item.view.*
import kotlinx.android.synthetic.main.freshman_recycle_item_edit_memo.view.*
import java.util.ArrayList

/**
 *created by chenyang
 *on 2019/8/6
 */

class EditMemoItemFragment : BaseViewModelFragment<DIYMemoBeanVM>() {
    override val viewModelClass: Class<DIYMemoBeanVM>
        get() = DIYMemoBeanVM::class.java

    private var onHintClickedListener : DIYMemoClicklistener ?= null

    private val dataList = ArrayList<DIYMemoBean>()
    private var adapter : DIYMemoAdapter ?= null
    private var listener : DIYMemoClicklistener?= null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_edit_memo_item, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setViewModel(view)


        adapter = context?.let { DIYMemoAdapter(it, dataList, R.layout.freshman_recycle_item_edit_memo) }
        rv_editable_unforgetable.layoutManager = LinearLayoutManager(context)
        rv_editable_unforgetable.adapter = adapter

      /**
         * 当box被选中之后，说明有可能被删除,通过这里可以统计被选中的item
         */
        adapter?.setCheckBoxClickListener(object : OnCheckBoxClickListener{

            //这里传进来的view时是总的view
            override fun OnClick(view: View, pos: Int) {

                val cb = view.cb_necessary_fold
                if (cb.isChecked) {
                    dataList.get(pos).isSelected = true
                    viewModel.updata(dataList.get(pos))
                    listener?.onClick(true)
                } else {
                    dataList.get(pos).isSelected = false
                    viewModel.updata(dataList.get(pos))
                    listener?.onClick(false)
                }
            }
        })

        tv_hint_no_memo.setOnClickListener {
            onHintClickedListener?.onClick(true)
        }
    }





    private fun setViewModel(view: View) {
        viewModel = ViewModelProviders.of(this).get(viewModelClass)
        viewModel.beans?.observe(this@EditMemoItemFragment, Observer {

            dataList.clear()
            dataList.addAll(it)

            if (dataList.size == 0) {
                view.tv_hint_no_memo.visibility = View.VISIBLE
                view.tv_hint_bg_memo.visibility = View.GONE
            }else{
                view.tv_hint_no_memo.visibility = View.GONE
            }

            adapter?.notifyDataSetChanged()


        })
    }

    fun setDIYMemoClicklistener(listener: DIYMemoClicklistener){
        this.listener = listener
    }

    fun setOnHintClickedListener(onHintClickedListener : DIYMemoClicklistener){
        this.onHintClickedListener = onHintClickedListener
    }

}