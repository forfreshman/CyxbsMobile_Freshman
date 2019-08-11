package com.mredrock.cyxbs.freshman.ui.fragment

<<<<<<< HEAD
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
=======
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
>>>>>>> upstream/master
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.DinningroomPageAdpter
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DiningroomViewModel
import kotlinx.android.synthetic.main.freshman_diningroom_fragment.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class DiningroomFragment : Fragment() {
    private val title = arrayListOf("千喜鹤","延生","红高粱","中心食堂","大西北")
    private var adapter :DinningroomPageAdpter?=null
    private var mView :View?=null
    private val details=ArrayList<String>()
    private val image=ArrayList<List<String>>()
    private val handler = @SuppressLint("HandlerLeak")
    object : Handler(){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                0 -> {
                    initData()
                    initTab()
                }
            }
        }
    }
=======
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.MyPageAdpter
import com.mredrock.cyxbs.freshman.ui.fragment.diningroom.*
import com.mredrock.cyxbs.freshman.viewmodel.fragment.DiningroomViewModel

class DiningroomFragment : Fragment() {
    private var  tabLayout : TabLayout?=null
    private var dinningViewpager: ViewPager?=null
    private val diningFragments=ArrayList<Fragment>()
    private val title =ArrayList<String>()
    private var adapter :MyPageAdpter?=null
    private var mView :View?=null
>>>>>>> upstream/master

    companion object {
        fun newInstance() = DiningroomFragment()
    }

    private lateinit var viewModel: DiningroomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.freshman_diningroom_fragment, container, false)
        return mView;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD
        createJson()
=======
        initData()
        initTab()
>>>>>>> upstream/master
        Log.d("begin:","dinning")
    }

    private fun initData(){
<<<<<<< HEAD
        adapter= DinningroomPageAdpter(title,details,image,activity as Context)
        adapter!!.initView()
        vp_guide_diningroom.adapter=adapter

    }

    private fun initTab(){
        tl_guide_diningroom.setupWithViewPager(vp_guide_diningroom)
        tl_guide_diningroom.setSelectedTabIndicatorHeight(0)
    }

    private fun createJson() {
        Thread(Runnable {
                val url = "http://129.28.185.138:9025/zsqy/json/3"
                val client = OkHttpClient()
                val request= Request.Builder()
                    .url(url)
                    .build()
                val response =client.newCall(request).execute()
                val body=response.body()!!.string()
                val jsonObject = JSONObject(body)
                val jsonArray = jsonObject.getJSONArray("text")
                for (i in 0 until jsonArray.getJSONObject(1).getJSONArray("message").length()){
                    val initJsonObject : JSONObject =jsonArray.getJSONObject(1)
                    val message=initJsonObject.getJSONArray("message")
                    details.add(message.getJSONObject(i).getString("detail"))
                    val images =ArrayList<String>()
                    for (j in 0 until message.getJSONObject(i).getJSONArray("photo").length()){
                        images.add("http://129.28.185.138:9025/zsqy/image/"+message.getJSONObject(i).getJSONArray("photo")[j])
                    }
                    image.add(images)
                }
            val message=Message()
            message.what=0
            handler.sendMessage(message)
        }).start()
=======
        title.add("千喜鹤")
        title.add("延生")
        title.add("红高粱")
        title.add("中心食堂")
        title.add("大西北")
        diningFragments.add(QXHFragment.newInstance())
        diningFragments.add(YSFragment.newInstance())
        diningFragments.add(HGLFragment.newInstance())
        diningFragments.add(ZXSTFragment.newInstance())
        diningFragments.add(DXBFragment.newInstance())
        dinningViewpager=activity!!.findViewById<View>(R.id.vp_guide_diningroom) as ViewPager
        adapter=MyPageAdpter(childFragmentManager,diningFragments,title)
        dinningViewpager!!.adapter=adapter
    }

    private fun initTab(){
        tabLayout=activity!!.findViewById<View>(R.id.tl_guide_diningroom) as TabLayout
        tabLayout!!.setupWithViewPager(dinningViewpager)
        tabLayout!!.setSelectedTabIndicatorHeight(0)
>>>>>>> upstream/master
    }
}
