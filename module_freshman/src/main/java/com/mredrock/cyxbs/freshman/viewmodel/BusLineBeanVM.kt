package com.mredrock.cyxbs.freshman.viewmodel

import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.db.repository.BusLineRepository
import com.mredrock.cyxbs.freshman.viewmodel.bean.BusLineBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean

/**
 *created by chenyang
 *on 2019/8/8
 */
class BusLineBeanVM : BaseViewModel() {

    var beans : LiveData<List<BusLineBean>> ?
    private  var repository : BusLineRepository

    init {
        repository = BusLineRepository()
        beans = repository.allBean
    }

    fun insertInitialItemBean(bean : BusLineBean){
        repository.insert(bean)
    }

    fun deletAll(){
        repository.deleteAll()
    }

    fun updata(bean : BusLineBean){
        repository.updata(bean)
    }

}