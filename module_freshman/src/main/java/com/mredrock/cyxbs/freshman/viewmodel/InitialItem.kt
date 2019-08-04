package com.mredrock.cyxbs.freshman.viewmodel



/**
 *created by chenyang
 *on 2019/8/2
 */


class InitialItem(var mainTitle: String?, var subhead: String?)

//class InitialItem(private var mainTitle: String?, private var subhead: String?) : BaseObservable() {
//
//    @Bindable
//    fun getMainTitle(): String? {
//        return mainTitle
//    }
//
//    fun setMainTitle(mainTitle: String?): InitialItem {
//        this.mainTitle = mainTitle
//        notifyPropertyChanged(BR.mainTitle)
//        //mainTitle?.let { LogUtils.d("maintitle***", it) }
//        return this
//    }
//
//    @Bindable
//    fun getSubhead(): String? {
//        return subhead
//    }
//
//    fun setSubhead(subhead: String?): InitialItem {
//        this.subhead = subhead
//        notifyPropertyChanged(BR.subhead)
//        return this
//    }
//
//    fun click() {
//        when (mainTitle){
//
//            "入学必备" -> LogUtils.d("入学必备","")
//            "指路重邮" -> LogUtils.d("指路重邮","")
//            "入学流程" -> LogUtils.d("入学流程","")
//            "校园指导" -> LogUtils.d("校园指导","")
//            "线上活动" -> LogUtils.d("线上活动","")
//            "更多功能" -> LogUtils.d("更多功能","")
//            "关于我们" -> LogUtils.d("关于我们","")
//
//        }
//    }
//
//}
