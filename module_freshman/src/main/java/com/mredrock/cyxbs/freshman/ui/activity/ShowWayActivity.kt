package com.mredrock.cyxbs.freshman.ui.activity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.fragment.BusLineFragment
import com.mredrock.cyxbs.freshman.ui.fragment.SchoolSceneryFragment
import kotlinx.android.synthetic.main.freshman_activity_show_way.*

class ShowWayActivity : BaseActivity() {

    override val isFragmentActivity: Boolean
        get() = false

    private val titles = arrayOf("公交路线", "校园风光")
    private val fragmentLists = listOf(
        BusLineFragment(),
        SchoolSceneryFragment()
    )
    private var fragmentAdapter: FragmentPagerAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_show_way)

        fragmentAdapter = MyFragmentAdapter(supportFragmentManager)
        //ViewPager的适配器获得Fragment的管理器
        vp_show_way.adapter = fragmentAdapter
        //将TabLayout和ViewPager绑定在一起
        tl_show_way.setupWithViewPager(vp_show_way)

        //点击导航栏的返回图标，则返回上一个activity
        common_toolbar.init(title = "指路重邮",
            listener = View.OnClickListener { v ->
            finish()
        })



    }

    inner class MyFragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return fragmentLists.get(position)
        }

        override fun getCount(): Int {
            return fragmentLists.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles.get(position)

        }

    }
}
