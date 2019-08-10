package com.mredrock.cyxbs.freshman.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.mredrock.cyxbs.common.ui.BaseFragment
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.DeliveryPageAdapter
import com.mredrock.cyxbs.freshman.utils.interfaces.NetService
import com.mredrock.cyxbs.freshman.viewmodel.bean.DeliveryBean
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DeliveryViewModel
import kotlinx.android.synthetic.main.freshman_delivery_fragment.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DeliveryFragment : BaseFragment() {

    private val names = arrayListOf("顺丰","韵达","中通","圆通","申通","邮政/EMS\"","菜鸟驿站（校外）","百世")
    private var adapter: DeliveryPageAdapter?=null
    private var mView :View?=null


    companion object {
        fun newInstance() = DeliveryFragment()
    }

    private lateinit var viewModel: DeliveryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.freshman_delivery_fragment, container, false)
        return mView;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("begin:","delivery")
        initData()
        initTab()
    }

    private fun initData(){
        adapter= DeliveryPageAdapter(names,activity as Context)
        Json()
        adapter!!.initView()
        vp_guide_delivery.adapter=adapter

    }


    private fun initTab(){
        tl_guide_delivery.setupWithViewPager(vp_guide_delivery)
        tl_guide_delivery.tabMode=TabLayout.MODE_SCROLLABLE
        tl_guide_delivery.setSelectedTabIndicatorHeight(0)
    }

    private fun Json(){
        val retrofit =Retrofit.Builder()
            .baseUrl("http://129.28.185.138:9025/zsqy/json/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
        val netService :NetService =retrofit.create(NetService::class.java)
        netService.getMessage()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Subscriber<DeliveryBean>(){
                override fun onNext(t: DeliveryBean) {
                    Log.d("AAA","aaa")
                    for (i in 0 until t.text?.size!!){
                        adapter!!.image[i]="http://129.28.185.138:9025/zsqy/image/"+ t.text!![i].message!![0].photo.toString()
                        Log.d("AAA", t.toString())
                        adapter!!.titles[i]= t.text!![i].message!![0].title.toString()
                        adapter!!.details[i] = t.text!![i].message!![0].detail.toString()
                    }
                }

                override fun onCompleted() {
                    Log.d("AAA","bbb")
                }

                override fun onError(e: Throwable?) {
                    Log.d("AAA","ccc")
                }

            })
    }
}
