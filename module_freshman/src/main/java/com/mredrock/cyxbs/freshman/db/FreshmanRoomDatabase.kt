package com.mredrock.cyxbs.freshman.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.freshman.utils.interfaces.BusLineBeanDao
import com.mredrock.cyxbs.freshman.utils.interfaces.FoldBeanDao
import com.mredrock.cyxbs.freshman.utils.interfaces.InitialItemBeanDao
import com.mredrock.cyxbs.freshman.viewmodel.bean.BusLineBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/6
 */


@Database(entities = [InitialItemBean::class, FoldBean::class, BusLineBean::class], version = 3)
abstract class FreshmanRoomDatabase : RoomDatabase() {

    abstract fun initialItemBeanDao(): InitialItemBeanDao
    abstract fun foldBeanDao() : FoldBeanDao
    abstract fun busLineBeanDao() : BusLineBeanDao

    companion object {

        private  var instance: FreshmanRoomDatabase ?= null


        fun getInstance(): FreshmanRoomDatabase ?{

            if (instance == null) {
                synchronized(FreshmanRoomDatabase::class.java) {
                    if (instance == null) {
                        instance =
                            Room.databaseBuilder(context, FreshmanRoomDatabase::class.java,
                                "freshman_database").build()
                    }
                }
            }
            return instance
        }
    }
}