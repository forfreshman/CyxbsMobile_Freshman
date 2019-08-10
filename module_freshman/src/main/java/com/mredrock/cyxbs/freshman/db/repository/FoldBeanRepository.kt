package com.mredrock.cyxbs.freshman.db.repository

import android.os.AsyncTask
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.utils.interfaces.FoldBeanDao
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean

/**
 *created by chenyang
 *on 2019/8/6
 */
class FoldBeanRepository() {

    var foldBeanDao: FoldBeanDao? = null
    var callback : MyCallback<FoldBean> ?= null
    init {

        InitThread().start()
        //while (initialItemBeanDao?.equals(null)!!){}
       // while (!isInitialFinished) {}
    }

    fun deleteAll() {
        DeleteAsyncTask(foldBeanDao).execute()
    }

    fun updata(bean: FoldBean) {
        UpdataAsyncTask(foldBeanDao).execute(bean)
    }

    fun insert(bean: FoldBean) {
        InsertAsyncTask(foldBeanDao).execute(bean)
    }


    inner class InitThread : Thread() {

        override fun run() {
            val db = FreshmanRoomDatabase.getInstance()
            foldBeanDao = db!!.foldBeanDao()

            val allFoldBean = foldBeanDao!!.getFoldBeanList()
            callback?.finished(allFoldBean)
        }

    }


    //更新
    private class UpdataAsyncTask(val beanDao: FoldBeanDao?) : AsyncTask<FoldBean, Void, Void>() {
        override fun doInBackground(vararg params: FoldBean): Void? {
            beanDao!!.updateFoldBeans(params[0])
            return null
        }

    }

    //插入
    private class InsertAsyncTask(val beanDao: FoldBeanDao?) : AsyncTask<FoldBean, Void, Void>() {
        override fun doInBackground(vararg params: FoldBean): Void? {
            beanDao!!.insert(params[0])
            return null
        }

    }

    //删除
    private class DeleteAsyncTask(val beanDao: FoldBeanDao?) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg voids: Void): Void? {
            beanDao!!.deleteAll()
            return null
        }

    }


}

