package com.mredrock.cyxbs.freshman.utils.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/6
 */
@Dao
interface InitialItemBeanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(initialItemBean: InitialItemBean)

    @Query("select * from InitialItemBean")
    fun getInitialItemBeanList (): LiveData<List<InitialItemBean>>

    @Query("delete from initialitembean")
    fun deleteAll()

    @Update
    fun updateInitialItemBeans(vararg initialItemBean: InitialItemBean)

}