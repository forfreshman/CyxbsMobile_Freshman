package com.mredrock.cyxbs.freshman.util

import com.google.gson.JsonObject
import com.mredrock.cyxbs.freshman.utils.interfaces.HandlerMessage
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject


//所有函数调用前先调用setMessage（）初始化message 重写抽象函数来sendmessage handler在对应的activity或fragment中创建


object JsonUtils {
    private var handlerMessage: HandlerMessage? = null

    fun setMessage(handlerMessage: HandlerMessage) {
        this.handlerMessage = handlerMessage;
    }

    /**入学必备
     * title :“报道必备”，“军训用品”,“以下为非必须”三个板块
     * name:录取通知书，防暑药等
     * detail:详细描述
     * name和detail调用方法：如 第一部分的第一个：name.get(0).get(0)
     */
    fun nessaryJson(admissonNeedList: ArrayList<JSONObject>, armyNeedList: ArrayList<JSONObject>, notNessaryList: ArrayList<JSONObject>) {
        Thread(Runnable {
            val url = "http://129.28.185.138:8080/zsqy/json/1"
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
                val data =initJsonObject.getJSONArray("data")
                for (j in 0 until data.length()){
                    when(i){
                        0-> admissonNeedList.add(data.getJSONObject(j))
                        1-> armyNeedList.add(data.getJSONObject(j))
                        2-> notNessaryList.add(data.getJSONObject(j))
                    }
                }
            }
            handlerMessage?.sendMessage()
        }).start()
    }

    /**入学流程
     * {
    "title": "报道时间",
    "message": "9月5日-6日",
    "photo": "",
    "detail": ""
    },
    {
    "title": "持相关证件至风雨操场报道",
    "message": "",
    "photo": "2-1.jpg",
    "detail": "风雨操场（体育馆）：新校门直走至三教处右转\r\n      各学院报道具体场地安排请结合相关信息\r\n"
    },
     */
    fun processJson(
        process:ArrayList<JSONObject>
    ) {
        Thread(Runnable {
            val url = "http://129.28.185.138:8080/zsqy/json/2"
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()
            val response = client.newCall(request).execute()
            val body = response.body()!!.string()
            val jsonObject = JSONObject(body)
            val jsonArray = jsonObject.getJSONArray("text")
            for (i in 0 until jsonArray.length()) {
                process.add(jsonArray.getJSONObject(i))

            }
            handlerMessage?.sendMessage()
        }).start()
    }


    //指路重邮部分

    /**公交路线
     *"text_1": {
     *" title": "重庆邮电大学地址",
     *"message": "重庆市南岸区南山街道崇文路2号重庆邮电大学"
     *},(这个地方可以写死，就不请求了）
     *
     * {
    "name": "江北机场",
    "route": [
    "江北机场乘坐三号线→南坪站下车从5号出口出站→乘坐346/347路公交车→邮电大学站下车",
    "乘坐机场大巴→上清寺后下车乘坐108路公交车→南坪站转乘346/347路公交车→邮电大学站下车"
    ]
    },
     */
    fun busLineJson(routes:ArrayList<JSONObject>) {
        Thread(Runnable {
            val url = "http://129.28.185.138:8080/zsqy/json/5"
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()
            val response = client.newCall(request).execute()
            val body = response.body()!!.string()
            val jsonObject = JSONObject(body)
            val jsonArray = jsonObject.getJSONObject("text_2")
            val initJsonArray = jsonArray.getJSONArray("message")
            for (i in 0 until initJsonArray.length()) {
               routes.add(initJsonArray.getJSONObject(i))
            }
            handlerMessage?.sendMessage()
        }).start()
    }

    /**校园风光
     * "message": [
    {
    "name": "八十万",
    "photo": "八十万.png"
    },
    {
    "name": "别有洞天",
    "photo": "别有洞天.png"
    },
     */
    fun schoolSceneJson(scene:ArrayList<JSONObject>){
        Thread(Runnable {
            val url = "http://129.28.185.138:8080/zsqy/json/6"
            val client = OkHttpClient()
            val request = Request.Builder()
                .url(url)
                .build()
            val response = client.newCall(request).execute()
            val body = response.body()!!.string()
            val jsonObject = JSONObject(body)
            val text = jsonObject.getJSONObject("text")
            val message=text.getJSONArray("message")
            for (i in 0 until message.length()) {
                scene.add(message.getJSONObject(i))
            }
            handlerMessage?.sendMessage()
        }).start()

    }
}


