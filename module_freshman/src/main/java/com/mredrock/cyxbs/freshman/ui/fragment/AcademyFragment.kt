package com.mredrock.cyxbs.freshman.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.ui.adapter.CommunicateAdapter
import com.mredrock.cyxbs.freshman.ui.adapter.ListAdapter
import kotlinx.android.synthetic.main.freshman_fragment_academy.*
import kotlinx.android.synthetic.main.freshman_fragment_fellow.*
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.support.v4.runOnUiThread
import org.json.JSONObject

class AcademyFragment : Fragment() {
    val names=ArrayList<String>()
    val qqs=ArrayList<String>()
    val searchNames=ArrayList<String>()
    val searchQQs=ArrayList<String>()
    private val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                0 -> {
                    val adapter = context?.let { CommunicateAdapter(names, it, names, qqs) }
                    rv_communicate.adapter = adapter
                    val layoutManager = LinearLayoutManager(context)
                    rv_communicate.layoutManager = layoutManager
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.freshman_fragment_academy, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createJson()
        et_academy.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                searchNames.clear()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                lv_communicate_search.visibility=View.INVISIBLE
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString()==""){
                    lv_communicate_search.visibility=View.INVISIBLE
                }else{
                    Thread(Runnable {
                        val url="http://129.28.185.138:8080/zsqy/select/college"
                        val client=OkHttpClient()
                        val responseBody = FormBody.Builder()
                            .add("college", p0.toString())
                            .build()
                        val request= Request.Builder()
                            .url(url)
                            .post(responseBody)
                            .build()
                        val response =client.newCall(request).execute()
                        val body=response.body()!!.string()
                        val jsonObject=JSONObject(body)
                        val info=jsonObject.getString("info")
                        if (info=="false"){
//                            Toast.makeText(context,"没有搜索到哦",Toast.LENGTH_SHORT).show()
                        }else if (info =="ok"){
                            val jsonArray=jsonObject.getJSONArray("text")
                            for (i in 0 until jsonArray.length()){
                                searchNames.add(jsonArray.getJSONObject(i).getString("name"))
                                searchQQs.add(jsonArray.getJSONObject(i).getString("data"))
                            }
                            runOnUiThread {
                                val adpter= context?.let { ListAdapter(it,R.layout.freshman_fellow_list_item,searchNames) }
                                lv_communicate_search.adapter=adpter
                                lv_communicate_search.visibility=View.VISIBLE
                            }
                        }

                    }).start()
                }

            }

        })
    }


    private fun createJson() {
        Thread(Runnable {
            val url = "http://129.28.185.138:8080/zsqy/json/7"
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()
            val response = client.newCall(request).execute()
            val body = response.body()!!.string()
            val jsonObject = JSONObject(body)
            val jsonArray = jsonObject.getJSONArray("text")
            for (i in 0 until jsonArray.length()) {
                val initJsonObject: JSONObject = jsonArray.getJSONObject(i)
                names.add(initJsonObject.getString("name"))
                qqs.add(initJsonObject.getString("data"))
            }
            val message=Message()
            message.what=0
            handler.sendMessage(message)
        }).start()
    }
}
