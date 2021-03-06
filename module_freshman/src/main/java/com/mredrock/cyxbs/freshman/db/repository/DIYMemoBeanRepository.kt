package com.mredrock.cyxbs.freshman.db.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.mredrock.cyxbs.freshman.db.FreshmanRoomDatabase
import com.mredrock.cyxbs.freshman.utils.interfaces.DIYMemoBeanDao
import com.mredrock.cyxbs.freshman.viewmodel.bean.DIYMemoBean

/**
 *created by chenyang
 *on 2019/8/10
 */
class DIYMemoBeanRepository {


    internal var allBean : LiveData<List<DIYMemoBean>>?= null
    var dao: DIYMemoBeanDao? = null
    init {
        val db = FreshmanRoomDatabase.getInstance()
        dao = db?.dIYMemoBeanDao()
        allBean = dao?.getDIYMemoBeanList()

    }

    fun deleteAll() {
        DeleteAsyncTask(dao).execute()
    }

    fun updata(bean: DIYMemoBean) {
        UpdataAsyncTask(dao).execute(bean)
    }

    fun insert(bean: DIYMemoBean) {
        InsertAsyncTask(dao).execute(bean)
    }

    fun delete(bean: DIYMemoBean){
        DeleteOneAsyncTask(dao).execute(bean)
    }

    fun getAll() : List<DIYMemoBean>?{

        val a = GetAllAsyncTask(dao)
        a.execute()
        return a.beanList
    }


    //更新
    private class UpdataAsyncTask(val beanDao: DIYMemoBeanDao?) : AsyncTask<DIYMemoBean, Void, Void>() {
        override fun doInBackground(vararg params: DIYMemoBean): Void? {
            beanDao!!.updateDIYMemoBeans(params[0])
            return null
        }

    }

    //插入
    private class InsertAsyncTask(val beanDao: DIYMemoBeanDao?) : AsyncTask<DIYMemoBean, Void, Void>() {
        override fun doInBackground(vararg params: DIYMemoBean): Void? {
            beanDao!!.insert(params[0])
            return null
        }

    }

    //删除
    private class DeleteAsyncTask(val beanDao: DIYMemoBeanDao?) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg voids: Void): Void? {
            beanDao!!.deleteAll()
            return null
        }

    }

    //删除
    private class DeleteOneAsyncTask(val beanDao: DIYMemoBeanDao?) : AsyncTask<DIYMemoBean, Void, Void>() {
        override fun doInBackground(vararg bean: DIYMemoBean): Void? {
            beanDao!!.delete(bean[0])
            return null
        }
    }


    //删除
    private class GetAllAsyncTask(val beanDao: DIYMemoBeanDao?) : AsyncTask<Void, Void, Void>() {

        internal var beanList : List<DIYMemoBean>?=null
        override fun doInBackground(vararg voids: Void): Void? {
            beanList =  beanDao!!.getAll()
            return null
        }

    }

}