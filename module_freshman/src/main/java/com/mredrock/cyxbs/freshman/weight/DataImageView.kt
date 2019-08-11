package com.mredrock.cyxbs.freshman.weight

import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.widget.ImageView

/**
 *created by chenyang
 *on 2019/8/2
 */

//自带信息的ImageView
class DataImageView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    ImageView(context, attrs, defStyleAttr) {

    var imagePath:String ?= ""
    var bitmap: Bitmap?= null


    constructor(context: Context?, attrs: AttributeSet?):this (context, attrs, 0)
    constructor(context: Context?) : this (context,null, 0)


}