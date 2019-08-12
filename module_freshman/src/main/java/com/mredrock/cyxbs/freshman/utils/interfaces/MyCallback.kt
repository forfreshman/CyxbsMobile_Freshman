package com.mredrock.cyxbs.freshman.utils.interfaces

import android.widget.EditText
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.viewmodel.bean.DIYMemoBean

/**
 *created by chenyang
 *on 2019/8/10
 */
interface MyCallback {

    fun OnDo(editText: EditText?, dataList : List<DIYMemoBean>?, viewModel: BaseViewModel?)
}