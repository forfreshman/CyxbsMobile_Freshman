package com.mredrock.cyxbs.freshman.viewmodel

import android.os.Parcel
import android.os.Parcelable

/**
 *created by chenyang
 *on 2019/8/4
 */
class SchoolSceneryBean (var sceneryName: String?, var sceneryImgeurl: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(sceneryName)
        dest.writeString(sceneryImgeurl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SchoolSceneryBean> {
        override fun createFromParcel(parcel: Parcel): SchoolSceneryBean {
            return SchoolSceneryBean(parcel)
        }

        override fun newArray(size: Int): Array<SchoolSceneryBean?> {
            return arrayOfNulls(size)
        }
    }
}