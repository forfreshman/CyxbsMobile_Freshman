package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
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

class DeliveryPageAdapter(private val title: List<String>,private val titles:List<String>,
                          private val image:List<String>,private val details:List<String>,private val activity : Context) :
        PagerAdapter(){


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
        Log.d("DD", image.size.toString())
        Glide.with(activity).load(image[0]).into(views[0].banner_sf)
        views[0].tv_guide_delivery_position.setText(title[0])
        views[0].tv_guide_delivery_desciption.setText(details[0])

        Glide.with(activity).load(image[1]).into(views[1].banner_yd)
        views[1].tv_guide_delivery_position.setText(title[1])
        views[1].tv_guide_delivery_desciption.setText(details[1])

        Glide.with(activity).load(image[2]).into(views[2].banner_zt)
        views[2].tv_guide_delivery_position_first.setText(title[2])
        views[2].tv_guide_delivery_desciption_first.setText(details[2])

        Glide.with(activity).load(image[3]).into(views[3].banner_yt)
        views[3].tv_guide_delivery_position.setText(title[3])
        views[3].tv_guide_delivery_desciption.setText(details[3])

        Glide.with(activity).load(image[4]).into(views[4].banner_st)
        views[4].tv_guide_delivery_position.setText(title[4])
        views[4].tv_guide_delivery_desciption.setText(details[4])

        Glide.with(activity).load(image[5]).into(views[5].banner_ems)
        views[5].tv_guide_delivery_position.setText(title[5])
        views[5].tv_guide_delivery_desciption.setText(details[5])

        Glide.with(activity).load(image[6]).into(views[6].banner_cnyz)
        views[6].tv_guide_delivery_position.setText(title[6])
        views[6].tv_guide_delivery_desciption.setText(details[6])

        Glide.with(activity).load(image[7]).into(views[7].banner_bs)
        views[7].tv_guide_delivery_position.setText(title[7])
        views[7].tv_guide_delivery_desciption.setText(details[7])
    }




}

