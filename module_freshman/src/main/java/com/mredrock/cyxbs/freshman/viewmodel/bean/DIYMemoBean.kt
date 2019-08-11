package com.mredrock.cyxbs.freshman.viewmodel.bean

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nullable

/**
 *created by chenyang
 *on 2019/8/10
 */
@Entity
class DIYMemoBean(@Nullable @PrimaryKey val DIYMemo : String ) {


    var isSelected = false

}