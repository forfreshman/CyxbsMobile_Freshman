package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.MyImageLoader
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.*
import java.lang.StringBuilder

class DeliveryPageAdapter(private val title: List<String>, private val activity : Context) :
        PagerAdapter(){
    private val stringBuilder =StringBuilder()
    private val image =ArrayList<String>()
    private val views=object : ArrayList<View>(){
        init {
            this.add(View.inflate(activity, R.layout.freshman_sf_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_yd_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_zt_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_yt_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_st_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_ems_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_cnyz_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_bs_fragment,null))
        }
    }

    override fun getCount(): Int {
        return views.size
  }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(views[position])
        return views[position]

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(views[position])
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }



    public fun initView(){
        for (i in 1 ..200){
            stringBuilder.append("啦")
        }
        image.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2434347346,2305367638&fm=26&gp=0.jpg")
        image.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2434347346,2305367638&fm=26&gp=0.jpg")
        image.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2434347346,2305367638&fm=26&gp=0.jpg")
        image.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2434347346,2305367638&fm=26&gp=0.jpg")

        views[0].banner_sf.setImages(image)
        views[0].banner_sf.setImageLoader(MyImageLoader())
        views[0].banner_sf.isAutoPlay(true)
        views[0].banner_sf.setIndicatorGravity(BannerConfig.CENTER)
        views[0].banner_sf.setBannerAnimation(Transformer.ZoomOutSlide)
        views[0].banner_sf.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[0].banner_sf.start()
        views[0].tv_guide_delivery_position.setText("知行苑五舍")
        views[0].tv_guide_delivery_desciption.setText(stringBuilder.toString())
    }




}

