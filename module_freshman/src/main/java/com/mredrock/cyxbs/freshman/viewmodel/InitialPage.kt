package com.mredrock.cyxbs.freshman.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.mredrock.cyxbs.freshman.BR

/**
 *created by chenyang
 *on 2019/8/2
 */

class InitialPage (private var mainTitle : String?, private var subhead : String?): BaseObservable() {

    @Bindable
    fun getMainTitle(): String? {
        return mainTitle
    }

    fun setMainTitle(mainTitle: String?) : InitialPage{
        this.mainTitle = mainTitle
        //notifyPropertyChanged(BR.mainTitle)
        return this
    }

    @Bindable
    fun getSubhead(): String? {
        return subhead
    }

    fun setSubhead(subhead: String? ) : InitialPage{
        this.subhead = subhead
        //notifyPropertyChanged(BR.subhead)
        return this
    }
}