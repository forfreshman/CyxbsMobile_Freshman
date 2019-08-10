package com.mredrock.cyxbs.freshman.viewmodel.bean

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nullable

/**
 *created by chenyang
 *on 2019/8/4
 */
@Entity
class BusLineBean(@PrimaryKey @Nullable val id: Int, var startStaton: String?, var sepficLine: String?)