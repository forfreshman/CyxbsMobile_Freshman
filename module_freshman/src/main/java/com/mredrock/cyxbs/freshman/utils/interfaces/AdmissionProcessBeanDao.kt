package com.mredrock.cyxbs.freshman.utils.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mredrock.cyxbs.freshman.viewmodel.bean.AdmissionProcessBean

/**
 *created by chenyang
 *on 2019/8/9
 */
@Dao
interface AdmissionProcessBeanDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bean: AdmissionProcessBean)

    @Query("select * from AdmissionProcessBean")
    fun getAdmissionProcessBeanList (): LiveData<List<AdmissionProcessBean>>

    @Query("delete from AdmissionProcessBean")
    fun deleteAll()

    @Update
    fun updateAdmissionProcessBeans(vararg bean : AdmissionProcessBean)


}