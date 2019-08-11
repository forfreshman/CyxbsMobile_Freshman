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
import com.mredrock.cyxbs.freshman.ui.adapter.HostelPageAdpter
import com.mredrock.cyxbs.freshman.viewmodel.fragment.HostelViewModel
import kotlinx.android.synthetic.main.freshman_hostel_fragment.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


class HostelFragment : Fragment() {

    private var title =object : ArrayList<String>(){
        init {
            this.add("知行苑")
            this.add("明理苑")
            this.add("宁静苑")
            this.add("兴业苑")
        }
    }
    private var adapter: HostelPageAdpter?=null
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
import com.mredrock.cyxbs.freshman.ui.fragment.hostel.MLYFragment
import com.mredrock.cyxbs.freshman.ui.fragment.hostel.NJYFragment
import com.mredrock.cyxbs.freshman.ui.fragment.hostel.XYYFragment
import com.mredrock.cyxbs.freshman.ui.fragment.hostel.ZXYFragment
import com.mredrock.cyxbs.freshman.viewmodel.fragment.HostelViewModel
import kotlin.math.log


class HostelFragment : Fragment() {
    private var  tabLayout : TabLayout?=null
    private var hostelViewpager: ViewPager?=null
    private val hostelFragments=ArrayList<Fragment>()
    private val title =ArrayList<String>()
    private var adapter: MyPageAdpter?=null
    private var mView :View?=null
>>>>>>> upstream/master

    companion object {
        fun newInstance() = HostelFragment()
    }

    private lateinit var viewModel: HostelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.freshman_hostel_fragment, container, false)
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
        Log.d("begin:","hostel")
    }

    private fun initData(){
<<<<<<< HEAD
        adapter=HostelPageAdpter(title,details,image,activity as Context)
        adapter!!.initView()
        vp_guide_hostel.adapter=adapter

    }

    private fun initTab(){
        tl_guide_hostel.setupWithViewPager(vp_guide_hostel)
        tl_guide_hostel.setSelectedTabIndicatorHeight(0)
=======
        title.add("知行苑")
        title.add("明理苑")
        title.add("宁静苑")
        title.add("兴业苑")
        hostelFragments.add(ZXYFragment.newInstance())
        hostelFragments.add(MLYFragment.newInstance())
        hostelFragments.add(NJYFragment.newInstance())
        hostelFragments.add(XYYFragment.newInstance())
        adapter=MyPageAdpter(childFragmentManager,hostelFragments,title)
        hostelViewpager=activity!!.findViewById<View>(R.id.vp_guide_hostel) as ViewPager
        hostelViewpager!!.adapter=adapter
    }

    private fun initTab(){
        tabLayout=activity!!.findViewById<View>(R.id.tl_guide_hostel) as TabLayout
        tabLayout!!.setupWithViewPager(hostelViewpager)
        tabLayout!!.setSelectedTabIndicatorHeight(0)
>>>>>>> upstream/master

    }


<<<<<<< HEAD
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
            for (i in 0 until jsonArray.getJSONObject(0).getJSONArray("message").length()){
                val initJsonObject : JSONObject =jsonArray.getJSONObject(0)
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
    }

=======
>>>>>>> upstream/master
}
