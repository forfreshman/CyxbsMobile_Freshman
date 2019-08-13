package com.mredrock.cyxbs.freshman.viewmodel

import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.db.repository.InitialItemBeanRepository
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/7
 */
class InitialItemBeanVM : BaseViewModel(){

//     var beans : LiveData<List<InitialItemBean>>?
    val repository: InitialItemBeanRepository

    init {

        repository = InitialItemBeanRepository()

//        beans = repository.allBean

    }



    fun insertInitialItemBean(bean : InitialItemBean){
//        repository.insert(bean)
    }

    fun deletAll(){
//        repository.deleteAll()
    }

    fun updata(bean : InitialItemBean){
//        repository.updata(bean)
    }

}