package com.mredrock.cyxbs.freshman.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.FragmentAdapter
import com.mredrock.cyxbs.freshman.ui.fragment.AcademyFragment
import com.mredrock.cyxbs.freshman.ui.fragment.ActivitiesFragment
import com.mredrock.cyxbs.freshman.ui.fragment.FellowFragment
import com.mredrock.cyxbs.freshman.weight.CursorView

import java.util.ArrayList

class CommunicateActivity : BaseActivity(), View.OnClickListener {
    private var academy: TextView? = null
    private var fellow: TextView? = null
    private var activities: TextView? = null
    private val fragments = ArrayList<Fragment>()
    private var viewPager: ViewPager? = null
    private var fragmentAdapter: FragmentAdapter? = null
    private var cursorView: CursorView? = null

    override val isFragmentActivity: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_communicate)
        initview()
        academy!!.setOnClickListener(this)
        fellow!!.setOnClickListener(this)
        activities!!.setOnClickListener(this)
        viewPager!!.setOnPageChangeListener(MyPagerChangeListener())

        fragments.add(AcademyFragment())
        fragments.add(FellowFragment())
        fragments.add(ActivitiesFragment())
        fragmentAdapter = FragmentAdapter(supportFragmentManager, fragments)
        viewPager!!.adapter = fragmentAdapter
        viewPager!!.currentItem = 0
        cursorView!!.setCounts(fragments.size)
        cursorView!!.setColor(R.color.common_default_text_color)
    }

    private fun initview() {
        academy = findViewById<View>(R.id.tv_academy) as TextView
        fellow = findViewById<View>(R.id.tv_fellow) as TextView
        activities = findViewById<View>(R.id.tv_activities) as TextView
        viewPager = findViewById<View>(R.id.vp_communicate) as ViewPager
        cursorView = findViewById<View>(R.id.curson_view) as CursorView
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_academy -> viewPager!!.currentItem = 0
            R.id.tv_fellow -> viewPager!!.currentItem = 1
            R.id.tv_activities -> viewPager!!.currentItem = 2
            else -> {
            }
        }
    }

    /**
     * 设置一个ViewPager的侦听事件，当左右滑动ViewPager时菜单栏被选中状态跟着改变
     */
    inner class MyPagerChangeListener : ViewPager.OnPageChangeListener {

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            cursorView!!.setXY(position, positionOffset)
        }

        override fun onPageSelected(position: Int) {

        }

        override fun onPageScrollStateChanged(state: Int) {

        }
    }
}
