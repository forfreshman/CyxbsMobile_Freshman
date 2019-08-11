package com.mredrock.cyxbs.freshman.db.repository

import android.os.AsyncTask
<<<<<<< HEAD
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.utils.interfaces.InitialItemBeanDao
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
=======
import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.utils.interfaces.InitialItemBeanDao
>>>>>>> upstream/master
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/6
 */
class InitialItemBeanRepository() {

<<<<<<< HEAD
    var allBean : List<InitialItemBean> ? = null
    var initialItemBeanDao: InitialItemBeanDao? = null
    var callback : MyCallback<InitialItemBean> ?= null
    init {

        InitThread().start()
        //while (initialItemBeanDao?.equals(null)!!){}
       // while (!isInitialFinished) {}
=======
    var allBean : LiveData<List<InitialItemBean>> ? = null
    var initialItemBeanDao: InitialItemBeanDao? = null
    init {

       val db = FreshmanRoomDatabase.getInstance()
        initialItemBeanDao = db?.initialItemBeanDao()
        allBean = initialItemBeanDao?.getInitialItemBeanList()
>>>>>>> upstream/master
    }


    fun deleteAll() {
        DeleteAsyncTask(initialItemBeanDao).execute()
    }

    fun updata(bean: InitialItemBean) {
        UpdataAsyncTask(initialItemBeanDao).execute(bean)
    }

    fun insert(bean: InitialItemBean) {
        InsertAsyncTask(initialItemBeanDao).execute(bean)
    }


<<<<<<< HEAD
    inner class InitThread : Thread() {

        override fun run() {
            val db = FreshmanRoomDatabase.getInstance()
            initialItemBeanDao = db!!.initialItemBeanDao()

            val allInitialitemBean = initialItemBeanDao!!.getInitialItemBeanList()
            callback?.finished(allInitialitemBean)
        }

    }

=======
>>>>>>> upstream/master

    //更新
    private class UpdataAsyncTask(val dao: InitialItemBeanDao?) : AsyncTask<InitialItemBean, Void, Void>() {
        override fun doInBackground(vararg params: InitialItemBean): Void? {
            dao!!.updateInitialItemBeans(params[0])
            return null
        }

    }

    //插入
    private class InsertAsyncTask(val dao: InitialItemBeanDao?) : AsyncTask<InitialItemBean, Void, Void>() {
        override fun doInBackground(vararg params: InitialItemBean): Void? {
            dao!!.insert(params[0])
            return null
        }

    }

    //删除
    private class DeleteAsyncTask(val dao: InitialItemBeanDao?) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg voids: Void): Void? {
            dao!!.deleteAll()
            return null
        }

    }
<<<<<<< HEAD


=======
>>>>>>> upstream/master
}

