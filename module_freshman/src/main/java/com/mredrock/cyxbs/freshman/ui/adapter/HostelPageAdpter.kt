package com.mredrock.cyxbs.freshman.ui.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.mredrock.cyxbs.freshman.R

class HostelPageAdpter(private val title: List<String>, private val activity :Context) :
    PagerAdapter() {

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
    private val views=object : ArrayList<View>(){
        init {
            this.add(View.inflate(activity, R.layout.freshman_zxy_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_mly_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_njy_fragment,null))
            this.add(View.inflate(activity, R.layout.freshman_xyy_fragment,null))
        }
    }
}
