package com.mredrock.cyxbs.freshman.db.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.utils.interfaces.BusLineBeanDao
import com.mredrock.cyxbs.freshman.viewmodel.bean.BusLineBean

/**
 *created by chenyang
 *on 2019/8/8
 */
class BusLineRepository {

    internal var allBean : LiveData<List<BusLineBean>> ?= null
    var busLineBeanDao: BusLineBeanDao? = null
    init {
        val db = FreshmanRoomDatabase.getInstance()
        busLineBeanDao = db?.busLineBeanDao()
        allBean = busLineBeanDao?.getBusLineBeanList()

    }

    fun deleteAll() {
        DeleteAsyncTask(busLineBeanDao).execute()
    }

    fun updata(bean: BusLineBean) {
        UpdataAsyncTask(busLineBeanDao).execute(bean)
    }

    fun insert(bean: BusLineBean) {
        InsertAsyncTask(busLineBeanDao).execute(bean)
    }



    //更新
    private class UpdataAsyncTask(val beanDao: BusLineBeanDao?) : AsyncTask<BusLineBean, Void, Void>() {
        override fun doInBackground(vararg params: BusLineBean): Void? {
            beanDao!!.updateBusLineBeans(params[0])
            return null
        }

    }

    //插入
    private class InsertAsyncTask(val beanDao: BusLineBeanDao?) : AsyncTask<BusLineBean, Void, Void>() {
        override fun doInBackground(vararg params: BusLineBean): Void? {
            beanDao!!.insert(params[0])
            return null
        }

    }

    //删除
    private class DeleteAsyncTask(val beanDao: BusLineBeanDao?) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg voids: Void): Void? {
            beanDao!!.deleteAll()
            return null
        }

    }
}