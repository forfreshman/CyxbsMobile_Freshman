package com.mredrock.cyxbs.freshman.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.FragmentAdapter
import com.mredrock.cyxbs.freshman.ui.fragment.DataFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DeliveryFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DiningroomFragment
import com.mredrock.cyxbs.freshman.ui.fragment.HostelFragment
import kotlinx.android.synthetic.main.freshman_activity_guide.*
import java.util.ArrayList


class GuideActivity : BaseActivity(), View.OnClickListener {
    private var hostel: TextView? = null
    private var diningroom: TextView? = null
    private var delivery: TextView? = null
    private var data:TextView?=null
    private var fragmentAdapter :FragmentAdapter?=null
    private val fragments=ArrayList<Fragment>()

    override val isFragmentActivity: Boolean
        get() = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_guide)
        //toolbar初始化
        common_toolbar.init(
            title = "校园指引" ,
            listener = View.OnClickListener { v ->
               finish()
            }
        )
        initData()
        //控件初始化
        initView()
        hostel!!.setOnClickListener (this)
        diningroom!!.setOnClickListener(this)
        delivery!!.setOnClickListener(this)
        data!!.setOnClickListener(this)
        vp_guide.currentItem=0
        hostel!!.setTextColor(Color.parseColor("#4b72ff"))
    }


    private fun initData(){
        fragments.add(HostelFragment.newInstance())
        fragments.add(DiningroomFragment.newInstance())
        fragments.add(DeliveryFragment.newInstance())
        fragments.add(DataFragment.newInstance())
    }


    private fun initView(){
        hostel=findViewById<View>(R.id.tv_guide_hostel) as TextView
        diningroom=findViewById<View>(R.id.tv_guide_dining_room) as TextView
        delivery=findViewById<View>(R.id.tv_guide_delivery) as TextView
        data=findViewById<View>(R.id.tv_guide_data) as TextView
        fragmentAdapter= FragmentAdapter(supportFragmentManager,fragments)
        vp_guide.setScanScroll(false)
        vp_guide.adapter=fragmentAdapter
    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_guide_hostel -> {
                vp_guide.currentItem=0
                hostel!!.setTextColor(Color.parseColor("#4b72ff"))
                diningroom!!.setTextColor(Color.parseColor("#515151"))
                delivery!!.setTextColor(Color.parseColor("#515151"))
                data!!.setTextColor(Color.parseColor("#515151"))}
            R.id.tv_guide_dining_room ->{
                vp_guide.currentItem=1
                hostel!!.setTextColor(Color.parseColor("#515151"))
                diningroom!!.setTextColor(Color.parseColor("#4b72ff"))
                delivery!!.setTextColor(Color.parseColor("#515151"))
                data!!.setTextColor(Color.parseColor("#515151"))}
            R.id.tv_guide_delivery->{
                vp_guide.currentItem=2
                hostel!!.setTextColor(Color.parseColor("#515151"))
                diningroom!!.setTextColor(Color.parseColor("#515151"))
                delivery!!.setTextColor(Color.parseColor("#4b72ff"))
                data!!.setTextColor(Color.parseColor("#515151"))}
            R.id.tv_guide_data->{
                vp_guide.currentItem=3
                hostel!!.setTextColor(Color.parseColor("#515151"))
                diningroom!!.setTextColor(Color.parseColor("#515151"))
                delivery!!.setTextColor(Color.parseColor("#515151"))
                data!!.setTextColor(Color.parseColor("#4b72ff"))}
        }
    }


}
