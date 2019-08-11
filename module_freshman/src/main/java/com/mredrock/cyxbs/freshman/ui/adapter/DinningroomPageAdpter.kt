package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.util.MyImageLoader
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.freshman_bs_fragment.view.*
import kotlinx.android.synthetic.main.freshman_cnyz_fragment.view.*
import kotlinx.android.synthetic.main.freshman_dxb_fragment.view.*
import kotlinx.android.synthetic.main.freshman_ems_fragment.view.*
import kotlinx.android.synthetic.main.freshman_hgl_fragment.view.*
import kotlinx.android.synthetic.main.freshman_qxh_fragment.view.*
import kotlinx.android.synthetic.main.freshman_qxh_fragment.view.tv_guide_dining_room_detail
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.tv_guide_delivery_desciption
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.tv_guide_delivery_position
import kotlinx.android.synthetic.main.freshman_st_fragment.view.*
import kotlinx.android.synthetic.main.freshman_yd_fragment.view.*
import kotlinx.android.synthetic.main.freshman_ys_fragment.view.*
import kotlinx.android.synthetic.main.freshman_yt_fragment.view.*
import kotlinx.android.synthetic.main.freshman_zt_fragment.view.*
import kotlinx.android.synthetic.main.freshman_zxst_fragment.view.*
import java.lang.StringBuilder

class DinningroomPageAdpter (private val title: List<String>,private val details:List<String>,
                             private val image:List<List<String>>,private val activity : Context) :
        PagerAdapter() {
    private val views=object : ArrayList<View>(){
        init {
            this.add(View.inflate(activity, R.layout.freshman_qxh_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_ys_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_hgl_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_zxst_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_dxb_fragment,null))
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
        views[0].banner_qxh.setImages(image[2])
        views[0].banner_qxh.setImageLoader(MyImageLoader())
        views[0].banner_qxh.isAutoPlay(true)
        views[0].banner_qxh.setIndicatorGravity(BannerConfig.CENTER)
        views[0].banner_qxh.setBannerAnimation(Transformer.ZoomOutSlide)
        views[0].banner_qxh.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[0].banner_qxh.start()
        views[0].tv_guide_dining_room_detail.setText(details[2])

        views[1].banner_ys.setImages(image[4])
        views[1].banner_ys.setImageLoader(MyImageLoader())
        views[1].banner_ys.isAutoPlay(true)
        views[1].banner_ys.setIndicatorGravity(BannerConfig.CENTER)
        views[1].banner_ys.setBannerAnimation(Transformer.ZoomOutSlide)
        views[1].banner_ys.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[1].banner_ys.start()
        views[1].tv_guide_dining_room_detail.setText(details[4])

        views[2].banner_hgl.setImages(image[1])
        views[2].banner_hgl.setImageLoader(MyImageLoader())
        views[2].banner_hgl.isAutoPlay(true)
        views[2].banner_hgl.setIndicatorGravity(BannerConfig.CENTER)
        views[2].banner_hgl.setBannerAnimation(Transformer.ZoomOutSlide)
        views[2].banner_hgl.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[2].banner_hgl.start()
        views[2].tv_guide_dining_room_detail.setText(details[1])

        views[3].banner_zzst.setImages(image[3])
        views[3].banner_zzst.setImageLoader(MyImageLoader())
        views[3].banner_zzst.isAutoPlay(true)
        views[3].banner_zzst.setIndicatorGravity(BannerConfig.CENTER)
        views[3].banner_zzst.setBannerAnimation(Transformer.ZoomOutSlide)
        views[3].banner_zzst.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[3].banner_zzst.start()
        views[3].tv_guide_dining_room_detail.setText(details[3])

        views[4].banner_dxb.setImages(image[0])
        views[4].banner_dxb.setImageLoader(MyImageLoader())
        views[4].banner_dxb.isAutoPlay(true)
        views[4].banner_dxb.setIndicatorGravity(BannerConfig.CENTER)
        views[4].banner_dxb.setBannerAnimation(Transformer.ZoomOutSlide)
        views[4].banner_dxb.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        views[4].banner_dxb.start()
        views[4].tv_guide_dining_room_detail.setText(details[0])
    }
}
