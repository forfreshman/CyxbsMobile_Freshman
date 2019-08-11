package com.mredrock.cyxbs.freshman.utils.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mredrock.cyxbs.freshman.viewmodel.bean.BusLineBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean

/**
 *created by chenyang
 *on 2019/8/8
 */

@Dao
interface BusLineBeanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bean: BusLineBean)

    @Query("select * from buslinebean")
    fun getBusLineBeanList (): LiveData<List<BusLineBean>>

    @Query("delete from buslinebean")
    fun deleteAll()

    @Update
    fun updateBusLineBeans(vararg bean : BusLineBean)

}