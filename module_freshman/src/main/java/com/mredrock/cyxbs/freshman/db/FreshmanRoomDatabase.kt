package com.mredrock.cyxbs.freshman.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mredrock.cyxbs.common.BaseApp.Companion.context
import com.mredrock.cyxbs.freshman.utils.interfaces.*
import com.mredrock.cyxbs.freshman.viewmodel.bean.*

/**
 *created by chenyang
 *on 2019/8/6
 */


@Database(entities = [InitialItemBean::class, FoldBean::class, BusLineBean::class,
    AdmissionProcessBean::class, DIYMemoBean::class], version = 6 )
abstract class FreshmanRoomDatabase : RoomDatabase() {

    abstract fun initialItemBeanDao(): InitialItemBeanDao
    abstract fun foldBeanDao() : FoldBeanDao
    abstract fun busLineBeanDao() : BusLineBeanDao
    abstract fun admissionProcessBeanDao() : AdmissionProcessBeanDao
    abstract fun dIYMemoBeanDao() : DIYMemoBeanDao

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

//
//        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE department " + " DELETE COLUMN INFO TEXT")
//            }
//        }


    }

}