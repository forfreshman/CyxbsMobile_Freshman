package com.mredrock.cyxbs.freshman.utils.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/7
 */

@Dao
interface FoldBeanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(foldBean: FoldBean)

    @Query("select * from foldbean")
    fun getFoldBeanList (): LiveData<List<FoldBean>>

    @Query("delete from foldbean")
    fun deleteAll()

    @Update
    fun updateFoldBeans(vararg bean : FoldBean)
}