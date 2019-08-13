package com.mredrock.cyxbs.freshman.utils.interfaces

import com.mredrock.cyxbs.freshman.viewmodel.bean.DeliveryBean
import retrofit2.Call
import retrofit2.http.GET
import rx.Observable

interface NetService {
    @GET("zsqy/json/33")
    fun getMessage() :Observable <DeliveryBean>
}