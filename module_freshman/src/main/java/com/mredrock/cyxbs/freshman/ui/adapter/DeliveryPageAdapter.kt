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
import kotlinx.android.synthetic.main.freshman_bs_fragment.view.*
import kotlinx.android.synthetic.main.freshman_cnyz_fragment.view.*
import kotlinx.android.synthetic.main.freshman_ems_fragment.view.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.tv_guide_delivery_desciption
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.tv_guide_delivery_position
import kotlinx.android.synthetic.main.freshman_st_fragment.view.*
import kotlinx.android.synthetic.main.freshman_yd_fragment.view.*
import kotlinx.android.synthetic.main.freshman_yt_fragment.view.*
import kotlinx.android.synthetic.main.freshman_zt_fragment.view.*
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

        views[1].banner_yd.setImages(image)
        views[1].banner_yd.setImageLoader(MyImageLoader())
        views[1].banner_yd.isAutoPlay(true)
        views[1].banner_yd.setIndicatorGravity(BannerConfig.CENTER)
        views[1].banner_yd.setBannerAnimation(Transformer.ZoomOutSlide)
        views[1].banner_yd.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[1].banner_yd.start()
        views[1].tv_guide_delivery_position.setText("知行苑五舍")
        views[1].tv_guide_delivery_desciption.setText(stringBuilder.toString())

        views[2].banner_zt_first.setImages(image)
        views[2].banner_zt_first.setImageLoader(MyImageLoader())
        views[2].banner_zt_first.isAutoPlay(true)
        views[2].banner_zt_first.setIndicatorGravity(BannerConfig.CENTER)
        views[2].banner_zt_first.setBannerAnimation(Transformer.ZoomOutSlide)
        views[2].banner_zt_first.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[2].banner_zt_first.start()
        views[2].tv_guide_delivery_position_first.setText("知行苑五舍")
        views[2].tv_guide_delivery_desciption_first.setText(stringBuilder.toString())

        views[2].banner_zt_second.setImages(image)
        views[2].banner_zt_second.setImageLoader(MyImageLoader())
        views[2].banner_zt_second.isAutoPlay(true)
        views[2].banner_zt_second.setIndicatorGravity(BannerConfig.CENTER)
        views[2].banner_zt_second.setBannerAnimation(Transformer.ZoomOutSlide)
        views[2].banner_zt_second.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[2].banner_zt_second.start()
        views[2].tv_guide_delivery_position_second.setText("知行苑五舍")
        views[2].tv_guide_delivery_desciption_second.setText(stringBuilder.toString())

        views[3].banner_yt.setImages(image)
        views[3].banner_yt.setImageLoader(MyImageLoader())
        views[3].banner_yt.isAutoPlay(true)
        views[3].banner_yt.setIndicatorGravity(BannerConfig.CENTER)
        views[3].banner_yt.setBannerAnimation(Transformer.ZoomOutSlide)
        views[3].banner_yt.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[3].banner_yt.start()
        views[3].tv_guide_delivery_position.setText("知行苑五舍")
        views[3].tv_guide_delivery_desciption.setText(stringBuilder.toString())

        views[4].banner_st.setImages(image)
        views[4].banner_st.setImageLoader(MyImageLoader())
        views[4].banner_st.isAutoPlay(true)
        views[4].banner_st.setIndicatorGravity(BannerConfig.CENTER)
        views[4].banner_st.setBannerAnimation(Transformer.ZoomOutSlide)
        views[4].banner_st.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[4].banner_st.start()
        views[4].tv_guide_delivery_position.setText("知行苑五舍")
        views[4].tv_guide_delivery_desciption.setText(stringBuilder.toString())

        views[5].banner_ems.setImages(image)
        views[5].banner_ems.setImageLoader(MyImageLoader())
        views[5].banner_ems.isAutoPlay(true)
        views[5].banner_ems.setIndicatorGravity(BannerConfig.CENTER)
        views[5].banner_ems.setBannerAnimation(Transformer.ZoomOutSlide)
        views[5].banner_ems.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[5].banner_ems.start()
        views[5].tv_guide_delivery_position.setText("知行苑五舍")
        views[5].tv_guide_delivery_desciption.setText(stringBuilder.toString())

        views[6].banner_cnyz.setImages(image)
        views[6].banner_cnyz.setImageLoader(MyImageLoader())
        views[6].banner_cnyz.isAutoPlay(true)
        views[6].banner_cnyz.setIndicatorGravity(BannerConfig.CENTER)
        views[6].banner_cnyz.setBannerAnimation(Transformer.ZoomOutSlide)
        views[6].banner_cnyz.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[6].banner_cnyz.start()
        views[6].tv_guide_delivery_position.setText("知行苑五舍")
        views[6].tv_guide_delivery_desciption.setText(stringBuilder.toString())

        views[7].banner_bs.setImages(image)
        views[7].banner_bs.setImageLoader(MyImageLoader())
        views[7].banner_bs.isAutoPlay(true)
        views[7].banner_bs.setIndicatorGravity(BannerConfig.CENTER)
        views[7].banner_bs.setBannerAnimation(Transformer.ZoomOutSlide)
        views[7].banner_bs.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[7].banner_bs.start()
        views[7].tv_guide_delivery_position.setText("知行苑五舍")
        views[7].tv_guide_delivery_desciption.setText(stringBuilder.toString())
    }




}

