package com.mredrock.cyxbs.freshman.utils.interfaces

import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/7
 */
interface MyCallback<T> {
   fun finished(beans: LiveData<List<T>>)
}