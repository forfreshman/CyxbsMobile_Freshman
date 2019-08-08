package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.MyImageLoader
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.freshman_bs_fragment.view.*
import kotlinx.android.synthetic.main.freshman_cnyz_fragment.view.*
import kotlinx.android.synthetic.main.freshman_ems_fragment.view.*
import kotlinx.android.synthetic.main.freshman_mly_fragment.view.*
import kotlinx.android.synthetic.main.freshman_njy_fragment.view.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.tv_guide_delivery_desciption
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.tv_guide_delivery_position
import kotlinx.android.synthetic.main.freshman_st_fragment.view.*
import kotlinx.android.synthetic.main.freshman_xyy_fragment.view.*
import kotlinx.android.synthetic.main.freshman_yd_fragment.view.*
import kotlinx.android.synthetic.main.freshman_yt_fragment.view.*
import kotlinx.android.synthetic.main.freshman_zt_fragment.view.*
import kotlinx.android.synthetic.main.freshman_zxy_fragment.view.*
import kotlinx.android.synthetic.main.freshman_zxy_fragment.view.tv_guide_hostel_detail
import java.lang.StringBuilder

class HostelPageAdpter(private val title: List<String>, private val activity :Context) :
    PagerAdapter() {
    private val stringBuilder = StringBuilder()
    private val image =ArrayList<String>()
    private val views=object : ArrayList<View>(){
        init {
            this.add(View.inflate(activity, R.layout.freshman_zxy_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_mly_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_njy_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_xyy_fragment,null))
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

        views[0].banner_zxy.setImages(image)
        views[0].banner_zxy.setImageLoader(MyImageLoader())
        views[0].banner_zxy.isAutoPlay(true)
        views[0].banner_zxy.setIndicatorGravity(BannerConfig.CENTER)
        views[0].banner_zxy.setBannerAnimation(Transformer.ZoomOutSlide)
        views[0].banner_zxy.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[0].banner_zxy.start()
        views[0].tv_guide_hostel_detail.setText(stringBuilder.toString())

        views[1].banner_mly.setImages(image)
        views[1].banner_mly.setImageLoader(MyImageLoader())
        views[1].banner_mly.isAutoPlay(true)
        views[1].banner_mly.setIndicatorGravity(BannerConfig.CENTER)
        views[1].banner_mly.setBannerAnimation(Transformer.ZoomOutSlide)
        views[1].banner_mly.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[1].banner_mly.start()
        views[1].tv_guide_hostel_detail.setText(stringBuilder.toString())

        views[2].banner_njy.setImages(image)
        views[2].banner_njy.setImageLoader(MyImageLoader())
        views[2].banner_njy.isAutoPlay(true)
        views[2].banner_njy.setIndicatorGravity(BannerConfig.CENTER)
        views[2].banner_njy.setBannerAnimation(Transformer.ZoomOutSlide)
        views[2].banner_njy.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[2].banner_njy.start()
        views[2].tv_guide_hostel_detail.setText(stringBuilder.toString())

        views[3].banner_xyy.setImages(image)
        views[3].banner_xyy.setImageLoader(MyImageLoader())
        views[3].banner_xyy.isAutoPlay(true)
        views[3].banner_xyy.setIndicatorGravity(BannerConfig.CENTER)
        views[3].banner_xyy.setBannerAnimation(Transformer.ZoomOutSlide)
        views[3].banner_xyy.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[3].banner_xyy.start()
        views[3].tv_guide_hostel_detail.setText(stringBuilder.toString())
    }

}
