package com.mredrock.cyxbs.freshman.viewmodel.bean

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mredrock.cyxbs.common.utils.LogUtils
import kotlinx.metadata.ClassName


/**
 *created by chenyang
 *on 2019/8/3
 */

@Entity
class FoldBean(@PrimaryKey @NonNull var id: Int, var mainMsg: String, var subMsg: String?) {

    //  val d = ClassName

}