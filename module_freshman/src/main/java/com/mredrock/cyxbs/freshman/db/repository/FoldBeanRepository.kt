package com.mredrock.cyxbs.freshman.db.repository

import android.os.AsyncTask
<<<<<<< HEAD
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.utils.interfaces.FoldBeanDao
import com.mredrock.cyxbs.freshman.utils.interfaces.MyCallback
=======
import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.utils.interfaces.FoldBeanDao
>>>>>>> upstream/master
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean

/**
 *created by chenyang
 *on 2019/8/6
 */
class FoldBeanRepository() {

    var foldBeanDao: FoldBeanDao? = null
<<<<<<< HEAD
    var callback : MyCallback<FoldBean> ?= null
    init {

        InitThread().start()
        //while (initialItemBeanDao?.equals(null)!!){}
       // while (!isInitialFinished) {}
=======
    var allBean: LiveData<List<FoldBean>>? = null


    init {

        val db = FreshmanRoomDatabase.getInstance()
        foldBeanDao = db?.foldBeanDao()
        allBean = foldBeanDao?.getFoldBeanList()
>>>>>>> upstream/master
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


<<<<<<< HEAD
    inner class InitThread : Thread() {

        override fun run() {
            val db = FreshmanRoomDatabase.getInstance()
            foldBeanDao = db!!.foldBeanDao()

            val allFoldBean = foldBeanDao!!.getFoldBeanList()
            callback?.finished(allFoldBean)
        }

    }

=======
>>>>>>> upstream/master

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

<<<<<<< HEAD

=======
>>>>>>> upstream/master
}

