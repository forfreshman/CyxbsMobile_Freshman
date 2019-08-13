package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.common.utils.extensions.setImageFromUrl
import com.mredrock.cyxbs.freshman.R
import kotlinx.android.synthetic.main.freshman_bs_fragment.view.*
import kotlinx.android.synthetic.main.freshman_cnyz_fragment.view.*
import kotlinx.android.synthetic.main.freshman_ems_fragment.view.*
import kotlinx.android.synthetic.main.freshman_jd_fragment.view.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.*
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.tv_guide_delivery_desciption
import kotlinx.android.synthetic.main.freshman_sf_fragment.view.tv_guide_delivery_position
import kotlinx.android.synthetic.main.freshman_st_fragment.view.*
import kotlinx.android.synthetic.main.freshman_yd_fragment.view.*
import kotlinx.android.synthetic.main.freshman_yt_fragment.view.*
import kotlinx.android.synthetic.main.freshman_zt_fragment.view.*

class DeliveryPageAdapter(private val title: List<String>,private val titles:List<String>,
                          private val image:List<String>,private val details:List<String>,
                          private val secondTitles:ArrayList<String>,
                          private val secondDetails:ArrayList<String>,
                          private val secondImages:ArrayList<String>,private val activity : Context) :
        PagerAdapter(){


    private val views=object : ArrayList<View>(){
        init {
            this.add(View.inflate(activity, R.layout.freshman_sf_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_jd_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_yt_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_st_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_yd_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_ems_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_bs_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_cnyz_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_zt_fragment,null))
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
        views[0].banner_sf.setImageFromUrl(image[0])
        views[0].tv_guide_delivery_position.setText(titles[0])
        views[0].tv_guide_delivery_desciption.setText(details[0])

        views[1].banner_jd.setImageFromUrl(image[1])
        views[1].tv_guide_delivery_position.setText(titles[1])
        views[1].tv_guide_delivery_desciption.setText(details[1])

        views[2].banner_yt.setImageFromUrl(image[2])
        views[2].tv_guide_delivery_position.setText(titles[2])
        views[2].tv_guide_delivery_desciption.setText(details[2])
        views[2].tv_guide_delivery_position_second.setText(secondTitles[0])
        views[2].tv_guide_delivery_desciption_second.setText(secondDetails[0])

        views[3].tv_guide_delivery_position.setText(titles[3])
        views[3].tv_guide_delivery_desciption.setText(details[3])
        views[3].tv_guide_delivery_position_second_st.setText(secondTitles[1])
        views[3].tv_guide_delivery_desciption_second_st.setText(secondDetails[1])

        views[4].banner_yd.setImageFromUrl(image[3])
        views[4].tv_guide_delivery_position.setText(titles[4])
        views[4].tv_guide_delivery_desciption.setText(details[4])
        views[4].tv_guide_delivery_position_second_yd.setText(secondTitles[2])
        views[4].tv_guide_delivery_desciption_second_yd.setText(secondDetails[2])

        views[5].banner_ems.setImageFromUrl(image[4])
        views[5].tv_guide_delivery_position.setText(titles[5])
        views[5].tv_guide_delivery_desciption.setText(details[5])
        views[5].tv_guide_delivery_position_second_ems.setText(secondTitles[3])
        views[5].tv_guide_delivery_desciption_second_ems.setText(secondDetails[3])
        views[5].banner_ems_second.setImageFromUrl(secondImages[0])

        views[6].banner_bs.setImageFromUrl(image[5])
        views[6].tv_guide_delivery_position.setText(titles[6])
        views[6].tv_guide_delivery_desciption.setText(details[6])

        views[7].banner_cnyz.setImageFromUrl(image[6])
        views[7].tv_guide_delivery_position.setText(titles[7])
        views[7].tv_guide_delivery_desciption.setText(details[7])

        views[8].banner_zt.setImageFromUrl(image[7])
        views[8].tv_guide_delivery_position_first.setText(titles[8])
        views[8].tv_guide_delivery_desciption_first.setText(details[8])

    }




}

