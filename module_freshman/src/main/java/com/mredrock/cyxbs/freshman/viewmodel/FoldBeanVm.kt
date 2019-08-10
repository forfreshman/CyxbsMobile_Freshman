package com.mredrock.cyxbs.freshman.viewmodel

import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
import com.mredrock.cyxbs.freshman.db.repository.FoldBeanRepository
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/7
 */
class FoldBeanVm : BaseViewModel() {

    lateinit var beans : LiveData<List<FoldBean>>

    var callback : MyCallback<FoldBean>?= null

    val repository: FoldBeanRepository

    init {

        repository = FoldBeanRepository()

        object : MyCallback<FoldBean> {
            override fun finished(beans : LiveData<List<FoldBean>>) {
                this@FoldBeanVm.beans = beans
                callback?.finished(beans)
            }
        }
    }

    fun insertInitialItemBean(bean : FoldBean){
        repository.insert(bean)
    }

    fun deletAll(){
        repository.deleteAll()
    }

    fun updata(bean : FoldBean){
        repository.updata(bean)
    }
}