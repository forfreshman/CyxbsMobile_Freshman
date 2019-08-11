package com.mredrock.cyxbs.freshman.viewmodel

import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.db.repository.DIYMemoBeanRepository
import com.mredrock.cyxbs.freshman.viewmodel.bean.DIYMemoBean

/**
 *created by chenyang
 *on 2019/8/10
 */
class DIYMemoBeanVM : BaseViewModel(){
    var beans : LiveData<List<DIYMemoBean>>?

    val repository: DIYMemoBeanRepository

    init {

        repository = DIYMemoBeanRepository()
        beans = repository.allBean
    }

    fun insertDITMemoBean(bean : DIYMemoBean){
        repository.insert(bean)
    }

    fun deletAll(){
        repository.deleteAll()
    }

    fun updata(bean : DIYMemoBean){
        repository.updata(bean)
    }
}