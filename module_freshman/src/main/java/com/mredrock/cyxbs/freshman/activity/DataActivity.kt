package com.mredrock.cyxbs.freshman.activity

import android.content.Intent
import android.graphics.Color
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.FragmentAdapter
import com.mredrock.cyxbs.freshman.ui.fragment.data.CourseFragment
import com.mredrock.cyxbs.freshman.ui.fragment.data.PercentFragment
import kotlinx.android.synthetic.main.freshman_activity_data.*
import kotlinx.android.synthetic.main.freshman_activity_guide.*

import java.util.ArrayList

class DataActivity : BaseActivity(), View.OnClickListener {
    override val isFragmentActivity: Boolean
        get() = true
    private var course: TextView? = null
    private var percent: TextView? = null
    private val fragments = ArrayList<Fragment>()
    private var dataViewPager: ViewPager? = null
    private var fragmentAdapter: FragmentAdapter? = null

    override fun onClick(v: View?) {
        when(v){
            course -> {
                dataViewPager!!.currentItem=0
                course!!.setTextColor(Color.parseColor("#6385ff"))
                percent!!.setTextColor(Color.parseColor("#333333"))
            }
            percent -> {
                dataViewPager!!.currentItem=1
                course!!.setTextColor(Color.parseColor("#333333"))
                percent!!.setTextColor(Color.parseColor("#6385ff"))
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_data)
        //toolbar初始化
        common_toolbar.init(
            title = "数据揭秘" ,
            listener = View.OnClickListener { v ->
                val intent = Intent(this,GuideActivity::class.java)
                startActivity(intent)
            }
        )
        initView()
        fragments.add(CourseFragment.newInstance())
        fragments.add(PercentFragment.newInstance())
        fragmentAdapter= FragmentAdapter(supportFragmentManager,fragments)
        dataViewPager!!.adapter=fragmentAdapter
        dataViewPager!!.currentItem=0
        course!!.setTextColor(Color.parseColor("#6385ff"))

        course!!.setOnClickListener(this)
        percent!!.setOnClickListener(this)
    }

    private fun initView() {
        course = findViewById<View>(R.id.tv_data_cource) as TextView
        percent = findViewById<View>(R.id.tv_data_percent) as TextView
        dataViewPager = findViewById<View>(R.id.vp_guide_data) as ViewPager
    }
}
