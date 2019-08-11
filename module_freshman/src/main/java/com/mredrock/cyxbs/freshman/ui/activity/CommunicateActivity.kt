package com.mredrock.cyxbs.freshman.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.FragmentAdapter
import com.mredrock.cyxbs.freshman.ui.fragment.communicate.AcademyFragment
import com.mredrock.cyxbs.freshman.ui.fragment.communicate.ActivitiesFragment
import com.mredrock.cyxbs.freshman.ui.fragment.communicate.FellowFragment

import java.util.ArrayList

class CommunicateActivity : BaseActivity(), View.OnClickListener {
    private var academy: TextView? = null
    private var fellow: TextView? = null
    private var activities: TextView? = null
    private val fragments = ArrayList<Fragment>()
    private var viewPager: ViewPager? = null
    private var fragmentAdapter: FragmentAdapter? = null


    override val isFragmentActivity: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_communicate)
        common_toolbar.init(
            title =  "线上交流",
            listener = View.OnClickListener { v -> finish() }
        )
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
        academy?.setTextColor(Color.parseColor("#4672ff"))
    }

    private fun initview() {
        academy = findViewById<View>(R.id.tv_academy) as TextView
        fellow = findViewById<View>(R.id.tv_fellow) as TextView
        activities = findViewById<View>(R.id.tv_activities) as TextView
        viewPager = findViewById<View>(R.id.vp_communicate) as ViewPager
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_academy -> {viewPager!!.currentItem = 0
                academy?.setTextColor(Color.parseColor("#4672ff"))
                fellow?.setTextColor(Color.parseColor("#333333"))
            activities?.setTextColor(Color.parseColor("#333333"))}
            R.id.tv_fellow ->{viewPager!!.currentItem = 1
                academy?.setTextColor(Color.parseColor("#333333"))
                fellow?.setTextColor(Color.parseColor("#4672ff"))
                activities?.setTextColor(Color.parseColor("#333333"))}
            R.id.tv_activities -> {viewPager!!.currentItem = 2
                academy?.setTextColor(Color.parseColor("#333333"))
                fellow?.setTextColor(Color.parseColor("#333333"))
                activities?.setTextColor(Color.parseColor("#4672ff"))}
        }
    }

    /**
     * 设置一个ViewPager的侦听事件，当左右滑动ViewPager时菜单栏被选中状态跟着改变
     */
    inner class MyPagerChangeListener : ViewPager.OnPageChangeListener {

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            when(position){
                0 -> {viewPager!!.currentItem = 0
                academy?.setTextColor(Color.parseColor("#4672ff"))
                        fellow?.setTextColor(Color.parseColor("#333333"))
                        activities?.setTextColor(Color.parseColor("#333333"))}

                1 -> {viewPager!!.currentItem = 1
                    academy?.setTextColor(Color.parseColor("#333333"))
                    fellow?.setTextColor(Color.parseColor("#4672ff"))
                    activities?.setTextColor(Color.parseColor("#333333"))}

                2 -> {viewPager!!.currentItem = 2
                    academy?.setTextColor(Color.parseColor("#333333"))
                    fellow?.setTextColor(Color.parseColor("#333333"))
                    activities?.setTextColor(Color.parseColor("#4672ff"))}
            }
        }

        override fun onPageScrollStateChanged(state: Int) {

        }
    }
}
