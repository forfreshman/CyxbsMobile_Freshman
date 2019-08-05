package com.mredrock.cyxbs.freshman.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.fragment.DataFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DeliveryFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DiningroomFragment
import com.mredrock.cyxbs.freshman.ui.fragment.HostelFragment



class GuideActivity : BaseActivity(), View.OnClickListener {
    private var hostel: TextView? = null
    private var diningroom: TextView? = null
    private var delivery: TextView? = null
    private var data:TextView?=null
    private var hostelFragment :HostelFragment?=null
    private var diningroomFragment :DiningroomFragment?=null
    private var deliveryFragment :DeliveryFragment?=null
    private var dataFragment :DataFragment?=null

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
        //控件初始化
        initView()
        hostel!!.setOnClickListener (this)
        diningroom!!.setOnClickListener(this)
        delivery!!.setOnClickListener(this)
        data!!.setOnClickListener(this)
        initHostelFragment()
        hostel!!.setTextColor(Color.parseColor("#4b72ff"))
    }


    private fun initHostelFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        if(hostelFragment == null){
            hostelFragment= HostelFragment.newInstance()
            transaction.add(R.id.fl_guide_second, hostelFragment!!)
        }
        hideFragment(transaction)
        transaction.show(hostelFragment!!)
        transaction.commit()
    }

    private fun initDiningroomFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        if(diningroomFragment == null){
            diningroomFragment= DiningroomFragment.newInstance()
            transaction.add(R.id.fl_guide_second, diningroomFragment!!)
        }
        hideFragment(transaction)
        transaction.show(diningroomFragment!!)
        transaction.commit()
    }

    private fun initDeliveryFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        if(deliveryFragment == null){
            deliveryFragment= DeliveryFragment.newInstance()
            transaction.add(R.id.fl_guide_second, deliveryFragment!!)
        }
        hideFragment(transaction)
        transaction.show(deliveryFragment!!)
        transaction.commit()
    }

    private fun initDataFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        if(dataFragment == null){
            dataFragment= DataFragment.newInstance()
            transaction.add(R.id.fl_guide_second, dataFragment!!)
        }
        hideFragment(transaction)
        transaction.show(dataFragment!!)
        transaction.commit()
    }

    private fun hideFragment(fragmentTransaction: FragmentTransaction){
            if(hostelFragment !=null){
                fragmentTransaction.hide(hostelFragment!!)
            }
            if(diningroomFragment != null) {
                fragmentTransaction.hide(diningroomFragment!!)
            }
            if(deliveryFragment != null) {
                fragmentTransaction.hide(deliveryFragment!!)
            }
            if(dataFragment != null) {
                fragmentTransaction.hide(dataFragment!!)
            }

    }


    private fun initView(){
        hostel=findViewById<View>(R.id.tv_guide_hostel) as TextView
        diningroom=findViewById<View>(R.id.tv_guide_dining_room) as TextView
        delivery=findViewById<View>(R.id.tv_guide_delivery) as TextView
        data=findViewById<View>(R.id.tv_guide_data) as TextView
    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tv_guide_hostel -> {
                initHostelFragment()
                hostel!!.setTextColor(Color.parseColor("#4b72ff"))
                diningroom!!.setTextColor(Color.parseColor("#515151"))
                delivery!!.setTextColor(Color.parseColor("#515151"))
                data!!.setTextColor(Color.parseColor("#515151"))}
            R.id.tv_guide_dining_room ->{
                initDiningroomFragment()
                hostel!!.setTextColor(Color.parseColor("#515151"))
                diningroom!!.setTextColor(Color.parseColor("#4b72ff"))
                delivery!!.setTextColor(Color.parseColor("#515151"))
                data!!.setTextColor(Color.parseColor("#515151"))}
            R.id.tv_guide_delivery->{
                initDeliveryFragment()
                hostel!!.setTextColor(Color.parseColor("#515151"))
                diningroom!!.setTextColor(Color.parseColor("#515151"))
                delivery!!.setTextColor(Color.parseColor("#4b72ff"))
                data!!.setTextColor(Color.parseColor("#515151"))}
            R.id.tv_guide_data->{
                initDataFragment()
                hostel!!.setTextColor(Color.parseColor("#515151"))
                diningroom!!.setTextColor(Color.parseColor("#515151"))
                delivery!!.setTextColor(Color.parseColor("#515151"))
                data!!.setTextColor(Color.parseColor("#4b72ff"))}
        }
    }


}
