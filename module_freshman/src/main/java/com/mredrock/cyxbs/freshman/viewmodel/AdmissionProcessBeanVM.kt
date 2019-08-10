//package com.mredrock.cyxbs.freshman.viewmodel
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
//import com.mredrock.cyxbs.common.viewmodel.BaseViewModel
//import com.mredrock.cyxbs.freshman.db.repository.AdmissionProcssRepository
//import com.mredrock.cyxbs.freshman.db.repository.BusLineRepository
//import com.mredrock.cyxbs.freshman.viewmodel.bean.AdmissionProcessBean
//import com.mredrock.cyxbs.freshman.viewmodel.bean.BusLineBean
//
///**
// *created by chenyang
// *on 2019/8/9
// */
//class AdmissionProcessBeanVM : BaseViewModel() {
//
//    var beans : LiveData<List<AdmissionProcessBean>>?
//    private  var repository : AdmissionProcssRepository
//
//    init {
//        repository = AdmissionProcssRepository()
//        beans = repository.allBean
//    }
//
//    fun insertAdmissionProcessBean(bean : AdmissionProcessBean){
//        repository.insert(bean)
//    }
//
//    fun deletAll(){
//        repository.deleteAll()
//    }
//
//    fun updata(bean : AdmissionProcessBean){
//        repository.updata(bean)
//    }
//}