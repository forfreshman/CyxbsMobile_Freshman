package com.mredrock.cyxbs.freshman.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.youth.banner.loader.ImageLoader

class MyImageLoader : ImageLoader() {
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        Glide.with(context!!.getApplicationContext())
            .load(path)
            .into(imageView!!);
    }
}