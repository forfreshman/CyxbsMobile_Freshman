package com.mredrock.cyxbs.freshman.db.repository

import android.os.AsyncTask

import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.utils.interfaces.FoldBeanDao
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean

/**
 *created by chenyang
 *on 2019/8/6
 */
class FoldBeanRepository() {

    var foldBeanDao: FoldBeanDao? = null
    var allBean: LiveData<List<FoldBean>>? = null


    init {

        val db = FreshmanRoomDatabase.getInstance()
        foldBeanDao = db?.foldBeanDao()
        allBean = foldBeanDao?.getFoldBeanList()

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

