package com.mredrock.cyxbs.freshman.viewmodel.bean

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 *created by chenyang
 *on 2019/8/2
 */

@Entity
class InitialItemBean(@PrimaryKey @NonNull var id: Int, var mainTitle: String, var subhead: String?)

