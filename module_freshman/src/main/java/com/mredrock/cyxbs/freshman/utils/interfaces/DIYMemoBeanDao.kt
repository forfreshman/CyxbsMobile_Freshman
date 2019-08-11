package com.mredrock.cyxbs.freshman.utils.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mredrock.cyxbs.freshman.viewmodel.bean.DIYMemoBean

/**
 *created by chenyang
 *on 2019/8/10
 */
@Dao
interface DIYMemoBeanDao {

    @Insert
    fun insert(bean: DIYMemoBean)

    @Query("select * from diymemoBean")
    fun getDIYMemoBeanList (): LiveData<List<DIYMemoBean>>

    @Query("delete from DIYMemoBean")
    fun deleteAll()

    @Update
    fun updateDIYMemoBeans(vararg bean : DIYMemoBean)
}