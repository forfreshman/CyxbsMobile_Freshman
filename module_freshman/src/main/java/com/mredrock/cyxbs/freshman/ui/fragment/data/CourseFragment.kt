package com.mredrock.cyxbs.freshman.ui.fragment.data

<<<<<<< HEAD
import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
=======
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
>>>>>>> upstream/master
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mredrock.cyxbs.freshman.R
<<<<<<< HEAD
import com.mredrock.cyxbs.freshman.ui.adapter.DataRecylerviewAdapter
import com.mredrock.cyxbs.freshman.ui.fragment.DataFragment
import com.mredrock.cyxbs.freshman.ui.fragment.DiningroomFragment
import kotlinx.android.synthetic.main.freshman_course_fragment.*
import kotlinx.android.synthetic.main.freshman_dialog_communicate.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.support.v4.runOnUiThread
import org.json.JSONObject

class CourseFragment : Fragment() {
    private val subjects=ArrayList<List<String>>()
    private val datas = ArrayList<List<String>>()
    private val dataFragment = DataFragment.newInstance()
    private val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                0 -> {
                    barGraghView.setName(subjects.get(0).get(0), subjects.get(0).get(1), subjects.get(0).get(2))
                    barGraghView.set(
                        datas.get(0).get(0).toDouble(),
                        datas.get(0).get(1).toDouble(),
                        datas.get(0).get(2).toDouble()
                    )
                }

                1 -> {
                    barGraghView.setName(subjects.get(1).get(0), subjects.get(1).get(1), subjects.get(1).get(2))
                    barGraghView.set(
                        datas.get(1).get(0).toDouble(),
                        datas.get(1).get(1).toDouble(),
                        datas.get(1).get(2).toDouble()
                    )
                }

                2 -> {
                    barGraghView.setName(subjects.get(2).get(0), subjects.get(2).get(1), subjects.get(2).get(2))
                    barGraghView.set(
                        datas.get(2).get(0).toDouble(),
                        datas.get(2).get(1).toDouble(),
                        datas.get(2).get(2).toDouble()
                    )
                }

                3 -> {
                    barGraghView.setName(subjects.get(3).get(0), subjects.get(3).get(1), subjects.get(3).get(2))
                    barGraghView.set(
                        datas.get(3).get(0).toDouble(),
                        datas.get(3).get(1).toDouble(),
                        datas.get(3).get(2).toDouble()
                    )
                }

                4 -> {
                    barGraghView.setName(subjects.get(4).get(0), subjects.get(4).get(1), subjects.get(4).get(2))
                    barGraghView.set(
                        datas.get(4).get(0).toDouble(),
                        datas.get(4).get(1).toDouble(),
                        datas.get(4).get(2).toDouble()
                    )
                }

                5 -> {
                    barGraghView.setName(subjects.get(5).get(0), subjects.get(5).get(1), subjects.get(5).get(2))
                    barGraghView.set(
                        datas.get(5).get(0).toDouble(),
                        datas.get(5).get(1).toDouble(),
                        datas.get(5).get(2).toDouble()
                    )
                }

                6 -> {
                    barGraghView.setName(subjects.get(0).get(0), subjects.get(0).get(1), subjects.get(0).get(2))
                    barGraghView.set(
                        datas.get(0).get(0).toDouble(),
                        datas.get(0).get(1).toDouble(),
                        datas.get(0).get(2).toDouble()
                    )
                }

                7 -> {
                    barGraghView.setName(subjects.get(7).get(0), subjects.get(7).get(1), subjects.get(7).get(2))
                    barGraghView.set(
                        datas.get(7).get(0).toDouble(),
                        datas.get(7).get(1).toDouble(),
                        datas.get(7).get(2).toDouble()
                    )
                }

                8 -> {
                    barGraghView.setName(subjects.get(8).get(0), subjects.get(8).get(1), subjects.get(8).get(2))
                    barGraghView.set(
                        datas.get(8).get(0).toDouble(),
                        datas.get(8).get(1).toDouble(),
                        datas.get(8).get(2).toDouble()
                    )
                }

                9 -> {
                    barGraghView.setName(subjects.get(9).get(0), subjects.get(9).get(1), subjects.get(9).get(2))
                    barGraghView.set(
                        datas.get(9).get(0).toDouble(),
                        datas.get(9).get(1).toDouble(),
                        datas.get(9).get(2).toDouble()
                    )
                }

                10 -> {
                    barGraghView.setName(subjects.get(10).get(0), subjects.get(10).get(1), subjects.get(10).get(2))
                    barGraghView.set(
                        datas.get(10).get(0).toDouble(),
                        datas.get(10).get(1).toDouble(),
                        datas.get(10).get(2).toDouble()
                    )
                }

                11 -> {
                    barGraghView.setName(subjects.get(11).get(0), subjects.get(11).get(1), subjects.get(11).get(2))
                    barGraghView.set(
                        datas.get(11).get(0).toDouble(),
                        datas.get(11).get(1).toDouble(),
                        datas.get(11).get(2).toDouble()
                    )
                }

                12 -> {
                    barGraghView.setName(subjects.get(12).get(0), subjects.get(12).get(1), subjects.get(12).get(2))
                    barGraghView.set(
                        datas.get(12).get(0).toDouble(),
                        datas.get(12).get(1).toDouble(),
                        datas.get(12).get(2).toDouble()
                    )
                }

                13 -> {
                    barGraghView.setName(subjects.get(13).get(0), subjects.get(13).get(1), subjects.get(13).get(2))
                    barGraghView.set(
                        datas.get(13).get(0).toDouble(),
                        datas.get(13).get(1).toDouble(),
                        datas.get(13).get(2).toDouble()
                    )
                }

                14 -> {
                    barGraghView.setName(subjects.get(14).get(0), subjects.get(14).get(1), subjects.get(14).get(2))
                    barGraghView.set(
                        datas.get(14).get(0).toDouble(),
                        datas.get(14).get(1).toDouble(),
                        datas.get(14).get(2).toDouble()
                    )
                }

                15 -> {
                    barGraghView.setName(subjects.get(15).get(0), subjects.get(15).get(1), subjects.get(15).get(2))
                    barGraghView.set(
                        datas.get(15).get(0).toDouble(),
                        datas.get(15).get(1).toDouble(),
                        datas.get(15).get(2).toDouble()
                    )
                }

                16 -> {
                    barGraghView.setName(subjects.get(16).get(0), subjects.get(16).get(1), subjects.get(16).get(2))
                    barGraghView.set(
                        datas.get(16).get(0).toDouble(),
                        datas.get(16).get(1).toDouble(),
                        datas.get(16).get(2).toDouble()
                    )
                }
            }
        }
    }
=======

class CourseFragment : Fragment() {
>>>>>>> upstream/master

    companion object {
        fun newInstance() = CourseFragment()
    }

    private lateinit var viewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.freshman_course_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CourseViewModel::class.java)
        // TODO: Use the ViewModel
    }

<<<<<<< HEAD
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createJson()
    }

    private fun createJson() {
        Thread(Runnable {
            val url = "http://129.28.185.138:9025/zsqy/json/4"
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()
            val response = client.newCall(request).execute()
            val body = response.body()!!.string()
            val jsonObject = JSONObject(body)
            val jsonArray = jsonObject.getJSONArray("text")
            Log.d("BBB",body.toString())
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
                datas.add(mDatas)
            }
            Log.d("AAA",subjects.size.toString())

            handler.sendMessage(dataFragment.message)
        }).start()
    }
=======
>>>>>>> upstream/master
}
