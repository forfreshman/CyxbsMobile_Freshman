package com.mredrock.cyxbs.freshman.viewmodel

import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.db.repository.InitialItemBeanRepository
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/7
 */
class InitialItemBeanVM : BaseViewModel(){

    lateinit var beans : LiveData<List<InitialItemBean>>
    var callback : MyCallback <InitialItemBean>?= null

    val repository: InitialItemBeanRepository

    init {

        repository = InitialItemBeanRepository()

        object : MyCallback<InitialItemBean> {
            override fun finished(beans: LiveData<List<InitialItemBean>>) {
                this@InitialItemBeanVM.beans = beans
                callback?.finished(beans)
            }


        }


    }


//    fun beans() : LiveData<List<InitialItemBean>>?{
//        return repository.allInitialitemBean
//    }

    fun insertInitialItemBean(bean : InitialItemBean){
        repository.insert(bean)
    }

    fun deletAll(){
        repository.deleteAll()
    }

    fun updata(bean : InitialItemBean){
        repository.updata(bean)
    }

}