package com.mredrock.cyxbs.freshman.viewmodel

import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.db.repository.FoldBeanRepository
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean

/**
 *created by chenyang
 *on 2019/8/7
 */
class FoldBeanVm : BaseViewModel() {

//     var beans : LiveData<List<FoldBean>>?


    val repository: FoldBeanRepository

    init {

        repository = FoldBeanRepository()
//        beans = repository.allBean
    }

    fun insertFoldBean(bean : FoldBean){
//        repository.insert(bean)
    }

    fun deletAll(){
//        repository.deleteAll()
    }

    fun updata(bean : FoldBean){
//        repository.updata(bean)
    }
}