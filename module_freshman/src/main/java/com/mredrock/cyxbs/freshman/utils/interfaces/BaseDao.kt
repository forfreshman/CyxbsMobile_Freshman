package com.mredrock.cyxbs.freshman.utils.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mredrock.cyxbs.freshman.viewmodel.bean.FoldBean
import com.mredrock.cyxbs.freshman.viewmodel.bean.InitialItemBean

/**
 *created by chenyang
 *on 2019/8/7
 */
@Dao
interface BaseDao <B>{

    @Insert
    fun insert(foldBean: B)

    @Query("select * from foldbean")
    fun getFoldBeanList (): LiveData<List<B>>

    @Query("delete from foldbean")
    fun deleteAll()

    @Update
    fun updateFoldBeans(vararg bean : B)
}