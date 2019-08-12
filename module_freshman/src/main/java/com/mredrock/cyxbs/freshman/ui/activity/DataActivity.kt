package com.mredrock.cyxbs.freshman.ui.activity

import android.annotation.SuppressLint
import android.graphics.Color
import android.widget.TextView
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.FragmentAdapter
import com.mredrock.cyxbs.freshman.ui.fragment.data.CourseFragment
import com.mredrock.cyxbs.freshman.ui.fragment.data.PercentFragment
import com.mredrock.cyxbs.freshman.util.JsonUtils
import com.mredrock.cyxbs.freshman.utils.interfaces.HandlerMessage
import com.mredrock.cyxbs.freshman.weight.FreshmanPieView
import kotlinx.android.synthetic.main.freshman_course_fragment.*
import kotlinx.android.synthetic.main.freshman_percent_fragment.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

import java.util.ArrayList

class DataActivity : BaseActivity(), View.OnClickListener {
    override val isFragmentActivity: Boolean
        get() = true
    private var course: TextView? = null
    private var percent: TextView? = null
    private val fragments = ArrayList<Fragment>()
    private var dataViewPager: ViewPager? = null
    private var fragmentAdapter: FragmentAdapter? = null
    private val subjects = ArrayList<List<String>>()
    private val courseDatas = ArrayList<List<String>>()
    private val names = ArrayList<String>()
    private val boys = ArrayList<Double>()
    private val girls = ArrayList<Double>()
    val courseMessage = Message()
    val percentMessage = Message()

    private val courseHandler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                0 -> {
                    barGraghView.setName(subjects.get(0).get(0), subjects.get(0).get(1), subjects.get(0).get(2))
                    barGraghView.set(
                        courseDatas.get(0).get(0).toDouble(),
                        courseDatas.get(0).get(1).toDouble(),
                        courseDatas.get(0).get(2).toDouble()
                    )
                }

                1 -> {
                    barGraghView.setName(subjects.get(1).get(0), subjects.get(1).get(1), subjects.get(1).get(2))
                    barGraghView.set(
                        courseDatas.get(1).get(0).toDouble(),
                        courseDatas.get(1).get(1).toDouble(),
                        courseDatas.get(1).get(2).toDouble()
                    )
                }

                2 -> {
                    barGraghView.setName(subjects.get(2).get(0), subjects.get(2).get(1), subjects.get(2).get(2))
                    barGraghView.set(
                        courseDatas.get(2).get(0).toDouble(),
                        courseDatas.get(2).get(1).toDouble(),
                        courseDatas.get(2).get(2).toDouble()
                    )
                }

                3 -> {
                    barGraghView.setName(subjects.get(3).get(0), subjects.get(3).get(1), subjects.get(3).get(2))
                    barGraghView.set(
                        courseDatas.get(3).get(0).toDouble(),
                        courseDatas.get(3).get(1).toDouble(),
                        courseDatas.get(3).get(2).toDouble()
                    )
                }

                4 -> {
                    barGraghView.setName(subjects.get(4).get(0), subjects.get(4).get(1), subjects.get(4).get(2))
                    barGraghView.set(
                        courseDatas.get(4).get(0).toDouble(),
                        courseDatas.get(4).get(1).toDouble(),
                        courseDatas.get(4).get(2).toDouble()
                    )
                }

                5 -> {
                    barGraghView.setName(subjects.get(5).get(0), subjects.get(5).get(1), subjects.get(5).get(2))
                    barGraghView.set(
                        courseDatas.get(5).get(0).toDouble(),
                        courseDatas.get(5).get(1).toDouble(),
                        courseDatas.get(5).get(2).toDouble()
                    )
                }

                6 -> {
                    barGraghView.setName(subjects.get(0).get(0), subjects.get(0).get(1), subjects.get(0).get(2))
                    barGraghView.set(
                        courseDatas.get(0).get(0).toDouble(),
                        courseDatas.get(0).get(1).toDouble(),
                        courseDatas.get(0).get(2).toDouble()
                    )
                }

                7 -> {
                    barGraghView.setName(subjects.get(7).get(0), subjects.get(7).get(1), subjects.get(7).get(2))
                    barGraghView.set(
                        courseDatas.get(7).get(0).toDouble(),
                        courseDatas.get(7).get(1).toDouble(),
                        courseDatas.get(7).get(2).toDouble()
                    )
                }

                8 -> {
                    barGraghView.setName(subjects.get(8).get(0), subjects.get(8).get(1), subjects.get(8).get(2))
                    barGraghView.set(
                        courseDatas.get(8).get(0).toDouble(),
                        courseDatas.get(8).get(1).toDouble(),
                        courseDatas.get(8).get(2).toDouble()
                    )
                }

                9 -> {
                    barGraghView.setName(subjects.get(9).get(0), subjects.get(9).get(1), subjects.get(9).get(2))
                    barGraghView.set(
                        courseDatas.get(9).get(0).toDouble(),
                        courseDatas.get(9).get(1).toDouble(),
                        courseDatas.get(9).get(2).toDouble()
                    )
                }

                10 -> {
                    barGraghView.setName(subjects.get(10).get(0), subjects.get(10).get(1), subjects.get(10).get(2))
                    barGraghView.set(
                        courseDatas.get(10).get(0).toDouble(),
                        courseDatas.get(10).get(1).toDouble(),
                        courseDatas.get(10).get(2).toDouble()
                    )
                }

                11 -> {
                    barGraghView.setName(subjects.get(11).get(0), subjects.get(11).get(1), subjects.get(11).get(2))
                    barGraghView.set(
                        courseDatas.get(11).get(0).toDouble(),
                        courseDatas.get(11).get(1).toDouble(),
                        courseDatas.get(11).get(2).toDouble()
                    )
                }

                12 -> {
                    barGraghView.setName(subjects.get(12).get(0), subjects.get(12).get(1), subjects.get(12).get(2))
                    barGraghView.set(
                        courseDatas.get(12).get(0).toDouble(),
                        courseDatas.get(12).get(1).toDouble(),
                        courseDatas.get(12).get(2).toDouble()
                    )
                }

                13 -> {
                    barGraghView.setName(subjects.get(13).get(0), subjects.get(13).get(1), subjects.get(13).get(2))
                    barGraghView.set(
                        courseDatas.get(13).get(0).toDouble(),
                        courseDatas.get(13).get(1).toDouble(),
                        courseDatas.get(13).get(2).toDouble()
                    )
                }

                14 -> {
                    barGraghView.setName(subjects.get(14).get(0), subjects.get(14).get(1), subjects.get(14).get(2))
                    barGraghView.set(
                        courseDatas.get(14).get(0).toDouble(),
                        courseDatas.get(14).get(1).toDouble(),
                        courseDatas.get(14).get(2).toDouble()
                    )
                }

                15 -> {
                    barGraghView.setName(subjects.get(15).get(0), subjects.get(15).get(1), subjects.get(15).get(2))
                    barGraghView.set(
                        courseDatas.get(15).get(0).toDouble(),
                        courseDatas.get(15).get(1).toDouble(),
                        courseDatas.get(15).get(2).toDouble()
                    )
                }

                16 -> {
                    barGraghView.setName(subjects.get(16).get(0), subjects.get(16).get(1), subjects.get(16).get(2))
                    barGraghView.set(
                        courseDatas.get(16).get(0).toDouble(),
                        courseDatas.get(16).get(1).toDouble(),
                        courseDatas.get(16).get(2).toDouble()
                    )
                }
            }
        }
    }


    private val percentHandler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                0 -> {
                    pieview_data.setMalePercent(boys[0])
                    pieview_data.setFemalePercent(girls[0])
                    pieview_data.setTitle(names[0])
                }

                1 -> {
                    pieview_data.setMalePercent(boys[1])
                    pieview_data.setFemalePercent(girls[1])
                    pieview_data.setTitle(names[1])
                }

                2 -> {
                    pieview_data.setMalePercent(boys[2])
                    pieview_data.setFemalePercent(girls[2])
                    pieview_data.setTitle(names[2])
                }

                3 -> {
                    pieview_data.setMalePercent(boys[3])
                    pieview_data.setFemalePercent(girls[3])
                    pieview_data.setTitle(names[3])
                }

                4 -> {
                    pieview_data.setMalePercent(boys[4])
                    pieview_data.setFemalePercent(girls[4])
                    pieview_data.setTitle(names[4])
                }

                5 -> {
                    pieview_data.setMalePercent(boys[5])
                    pieview_data.setFemalePercent(girls[5])
                    pieview_data.setTitle(names[5])
                }

                6 -> {
                    pieview_data.setMalePercent(boys[6])
                    pieview_data.setFemalePercent(girls[6])
                    pieview_data.setTitle(names[6])
                }

                7 -> {
                    pieview_data.setMalePercent(boys[7])
                    pieview_data.setFemalePercent(girls[7])
                    pieview_data.setTitle(names[7])
                }

                8 -> {
                    pieview_data.setMalePercent(boys[8])
                    pieview_data.setFemalePercent(girls[8])
                    pieview_data.setTitle(names[8])
                }

                9 -> {
                    pieview_data.setMalePercent(boys[9])
                    pieview_data.setFemalePercent(girls[9])
                    pieview_data.setTitle(names[9])
                }

                10 -> {
                    pieview_data.setMalePercent(boys[10])
                    pieview_data.setFemalePercent(girls[10])
                    pieview_data.setTitle(names[10])
                }

                11 -> {
                    pieview_data.setMalePercent(boys[11])
                    pieview_data.setFemalePercent(girls[11])
                    pieview_data.setTitle(names[11])
                }

                12 -> {
                    pieview_data.setMalePercent(boys[12])
                    pieview_data.setFemalePercent(girls[12])
                    pieview_data.setTitle(names[12])
                }

                13 -> {
                    pieview_data.setMalePercent(boys[13])
                    pieview_data.setFemalePercent(girls[13])
                    pieview_data.setTitle(names[13])
                }

                14 -> {
                    pieview_data.setMalePercent(boys[14])
                    pieview_data.setFemalePercent(girls[14])
                    pieview_data.setTitle(names[14])
                }

                15 -> {
                    pieview_data.setMalePercent(boys[15])
                    pieview_data.setFemalePercent(girls[15])
                    pieview_data.setTitle(names[15])
                }

                16 -> {
                    pieview_data.setMalePercent(boys[16])
                    pieview_data.setFemalePercent(girls[16])
                    pieview_data.setTitle(names[16])
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            course -> {
                dataViewPager!!.currentItem = 0
                course!!.setTextColor(Color.parseColor("#6385ff"))
                percent!!.setTextColor(Color.parseColor("#333333"))
            }
            percent -> {
                dataViewPager!!.currentItem = 1
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
            title = "数据揭秘",
            listener = View.OnClickListener { v ->
                finish()
            }
        )
        initView()
        fragments.add(CourseFragment.newInstance())
        fragments.add(PercentFragment.newInstance())
        fragmentAdapter = FragmentAdapter(supportFragmentManager, fragments)
        dataViewPager!!.adapter = fragmentAdapter
        dataViewPager!!.currentItem = 0
        course!!.setTextColor(Color.parseColor("#6385ff"))

        course!!.setOnClickListener(this)
        percent!!.setOnClickListener(this)
        dataViewPager!!.setOnPageChangeListener(MyPagerChangeListener())
        createCourseJson()
        createPercentJson()
    }

    private fun initView() {
        course = findViewById<View>(R.id.tv_data_cource) as TextView
        percent = findViewById<View>(R.id.tv_data_percent) as TextView
        dataViewPager = findViewById<View>(R.id.vp_guide_data) as ViewPager
    }

    inner private class MyPagerChangeListener : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {

        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

        }

        override fun onPageSelected(position: Int) {
            when (position) {
                0 -> {
                    dataViewPager!!.currentItem = 0
                    course!!.setTextColor(Color.parseColor("#6385ff"))
                    percent!!.setTextColor(Color.parseColor("#333333"))
                }

                1 -> {
                    dataViewPager!!.currentItem = 1
                    course!!.setTextColor(Color.parseColor("#333333"))
                    percent!!.setTextColor(Color.parseColor("#6385ff"))
                }
            }
        }

    }


    private fun createCourseJson() {
        Thread(Runnable {
            val url = "http://129.28.185.138:8080/zsqy/json/4"
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()
            val response = client.newCall(request).execute()
            val body = response.body()!!.string()
            val jsonObject = JSONObject(body)
            val jsonArray = jsonObject.getJSONArray("text")
            Log.d("BBB", body.toString())
            for (i in 0 until jsonArray.length()) {
                val initJsonObject: JSONObject = jsonArray.getJSONObject(i)
                val message = initJsonObject.getJSONArray("message")
                val mSubjects = ArrayList<String>()
                val mDatas = ArrayList<String>()
                for (j in 0 until message.length()) {
                    mSubjects.add(message.getJSONObject(j).getString("subject"))
                    mDatas.add(message.getJSONObject(j).getString("data"))
                }
                subjects.add(mSubjects)
                courseDatas.add(mDatas)
            }
            Log.d("AAA", subjects.size.toString())
            val intent = intent
            val bundle = intent.extras
            val position = bundle.getInt("position")
            courseMessage.what = position
            courseHandler.sendMessage(courseMessage)
        }).start()
    }


    private fun createPercentJson() {
        Thread(Runnable {
            val url = "http://129.28.185.138:8080/zsqy/json/44"
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()
            val response = client.newCall(request).execute()
            val body = response.body()!!.string()
            val jsonObject = JSONObject(body)
            val jsonArray = jsonObject.getJSONArray("text")
            Log.d("BBB", body.toString())
            for (i in 0 until jsonArray.length()) {
                val initJsonObject: JSONObject = jsonArray.getJSONObject(i)
                names.add(initJsonObject.getString("name"))
                boys.add(initJsonObject.getString("boy").replace("%", "").toDouble())
                girls.add(initJsonObject.getString("girl").replace("%", "").toDouble())
            }
            Log.d("AAA", subjects.size.toString())
            val intent = intent
            val bundle = intent.extras
            val position = bundle.getInt("position")
            percentMessage.what = position
            percentHandler.sendMessage(percentMessage)
        }).start()
    }
}
