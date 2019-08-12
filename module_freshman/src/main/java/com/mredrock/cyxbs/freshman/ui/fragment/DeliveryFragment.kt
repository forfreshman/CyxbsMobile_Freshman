package com.mredrock.cyxbs.freshman.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
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
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


class DeliveryFragment : BaseFragment() {

    private val names = arrayListOf("顺丰", "京东", "圆通", "申通", "韵达", "邮政/EMS", "百世", "菜鸟驿站（校外）", "中通")
    private var adapter: DeliveryPageAdapter? = null
    private var mView: View? = null
    val details = ArrayList<String>()
    val image = ArrayList<String>()
    val titles = ArrayList<String>()
    val secondTitles = ArrayList<String>()
    val secondDetails = ArrayList<String>()
    val secondImages = ArrayList<String>()
    private val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                0 -> {
                    initData()
                    initTab()
                }
            }
        }
    }


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
        Log.d("begin:", "delivery")
        createJson()

    }

    private fun createJson() {
        Thread(Runnable {
            val url = "http://129.28.185.138:8080/zsqy/json/33"
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()
            val response = client.newCall(request).execute()
            val body = response.body()!!.string()
            val jsonObject = JSONObject(body)
            val jsonArray = jsonObject.getJSONArray("text")
            for (i in 0 until jsonArray.length()) {
                val initJsonObject = jsonArray.getJSONObject(i)
                val message = initJsonObject.getJSONArray("message")
                when (i) {
                    2 -> {
                        secondTitles.add(message.getJSONObject(1).getString("title"))
                        secondDetails.add(message.getJSONObject(1).getString("detail"))
                    }
                    3 -> {
                        secondTitles.add(message.getJSONObject(1).getString("title"))
                        secondDetails.add(message.getJSONObject(1).getString("detail"))
                    }
                    4 -> {
                        secondTitles.add(message.getJSONObject(1).getString("title"))
                        secondDetails.add(message.getJSONObject(1).getString("detail"))
                    }
                    5 -> {
                        secondTitles.add(message.getJSONObject(1).getString("title"))
                        secondDetails.add(message.getJSONObject(1).getString("detail"))
                        secondImages.add("http://129.28.185.138:8080/zsqy/image/" + message.getJSONObject(1).getString("photo"))
                    }
                }
                titles.add(message.getJSONObject(0).getString("title"))
                Log.d("哈哈哈", titles[i])
                details.add(message.getJSONObject(0).getString("detail"))
                if (i !=3){
                    image.add("http://129.28.185.138:9025/zsqy/image/" + message.getJSONObject(0).getString("photo"))
                }
            }
            val message = Message()
            message.what = 0
            handler.sendMessage(message)
        }).start()

    }

    private fun initData() {
        adapter = DeliveryPageAdapter(
            names,
            titles,
            image,
            details,
            secondTitles,
            secondDetails,
            secondImages,
            activity as Context
        )
        adapter!!.initView()
        vp_guide_delivery.adapter = adapter

    }


    private fun initTab() {
        tl_guide_delivery.setupWithViewPager(vp_guide_delivery)
        tl_guide_delivery.tabMode = TabLayout.MODE_SCROLLABLE
        tl_guide_delivery.setSelectedTabIndicatorHeight(0)
    }

}
