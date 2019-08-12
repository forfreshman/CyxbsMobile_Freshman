package com.mredrock.cyxbs.freshman.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mredrock.cyxbs.common.ui.BaseViewModelFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
import com.mredrock.cyxbs.freshman.viewmodel.DIYMemoBeanVM
import com.mredrock.cyxbs.freshman.viewmodel.bean.DIYMemoBean
import kotlinx.android.synthetic.main.freshman_fragment_add_memo_item.view.*

/**
 *created by chenyang
 *on 2019/8/6
 */
class AddMemoItemFragment : BaseViewModelFragment<DIYMemoBeanVM>() {
    override val viewModelClass: Class<DIYMemoBeanVM>
        get() = DIYMemoBeanVM::class.java

    private var ETView: View ?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.freshman_fragment_add_memo_item, container, false)
        ETView = view.et_add_memo_item
        return view
    }

    private var listener : MyCallback?= null
    private var dataList = ArrayList<DIYMemoBean>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel = ViewModelProviders.of(this@AddMemoItemFragment).get(viewModelClass)

        viewModel.beans?.observe(this@AddMemoItemFragment, Observer {
            dataList.clear()
            dataList.addAll(it)

        })

    }


    fun setListener(listener: MyCallback){
        this.listener = listener
    }

    override fun onStop() {
        super.onStop()
        listener?.OnDo(view!!.et_add_memo_item, dataList, viewModel)

    }

    fun getETView(): View?{
        return ETView
    }

}