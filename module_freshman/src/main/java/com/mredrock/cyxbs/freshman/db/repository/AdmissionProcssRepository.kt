//package com.mredrock.cyxbs.freshman.db.repository
//
//import android.os.AsyncTask
//import androidx.lifecycle.LiveData
//import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
//import com.mredrock.cyxbs.freshman.utils.interfaces.AdmissionProcessBeanDao
//import com.mredrock.cyxbs.freshman.viewmodel.bean.AdmissionProcessBean
//
///**
// *created by chenyang
// *on 2019/8/9
// */
//class AdmissionProcssRepository {
//
//    internal var allBean : LiveData<List<AdmissionProcessBean>>?= null
//    var admissionProcessBeanDao: AdmissionProcessBeanDao? = null
//    init {
//        val db = FreshmanRoomDatabase.getInstance()
//        admissionProcessBeanDao = db?.admissionProcessBeanDao()
//        allBean = admissionProcessBeanDao?.getAdmissionProcessBeanList()
//
//    }
//
//    fun deleteAll() {
//        DeleteAsyncTask(admissionProcessBeanDao).execute()
//    }
//
//    fun updata(bean: AdmissionProcessBean) {
//        UpdataAsyncTask(admissionProcessBeanDao).execute(bean)
//    }
//
//    fun insert(bean: AdmissionProcessBean) {
//        InsertAsyncTask(admissionProcessBeanDao).execute(bean)
//    }
//
//
//    //更新
//    private class UpdataAsyncTask(val beanDao: AdmissionProcessBeanDao?) : AsyncTask<AdmissionProcessBean, Void, Void>() {
//        override fun doInBackground(vararg params: AdmissionProcessBean): Void? {
//            beanDao!!.updateAdmissionProcessBeans(params[0])
//            return null
//        }
//
//    }
//
//    //插入
//    private class InsertAsyncTask(val beanDao: AdmissionProcessBeanDao?) : AsyncTask<AdmissionProcessBean, Void, Void>() {
//        override fun doInBackground(vararg params: AdmissionProcessBean): Void? {
//            beanDao!!.insert(params[0])
//            return null
//        }
//
//    }
//
//    //删除
//    private class DeleteAsyncTask(val beanDao: AdmissionProcessBeanDao?) : AsyncTask<Void, Void, Void>() {
//        override fun doInBackground(vararg voids: Void): Void? {
//            beanDao!!.deleteAll()
//            return null
//        }
//
//    }
//
//}