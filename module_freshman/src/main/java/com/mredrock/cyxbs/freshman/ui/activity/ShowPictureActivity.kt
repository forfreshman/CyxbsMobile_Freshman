package com.mredrock.cyxbs.freshman.ui.activity

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import com.bumptech.glide.Glide
import com.mredrock.cyxbs.common.ui.BaseActivity
import com.mredrock.cyxbs.freshman.R
import com.mredrock.cyxbs.freshman.viewmodel.SchoolSceneryBean
import kotlinx.android.synthetic.main.freshman_activity_show_picture.*

class ShowPictureActivity : BaseActivity() {
    override val isFragmentActivity: Boolean
        get() = false

    private lateinit var gestureDetector : GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.freshman_activity_show_picture)

        val intent = intent
        val bundel = intent.getBundleExtra("dataBundel")
        val dataList = bundel.getSerializable("dataList") as List<*>
        val currentPicPos = bundel.getInt("currentPicPos")

        val onGestureListener = getOnGestureListener(dataList, currentPicPos)

        val currentBean = dataList.get(currentPicPos) as SchoolSceneryBean
      //  LogUtils.d("currentBean",""+currentBean.sceneryName)

        //Glide.with(this).load(R.drawable.bbbbb).into(iv_school_scenery_big)
        gestureDetector = GestureDetector(this, onGestureListener)







    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    private fun getOnGestureListener(dataList: List<*>, _count: Int): GestureDetector.SimpleOnGestureListener {
        var count = _count
        val onGestureListener = object : GestureDetector.SimpleOnGestureListener() {
            //当识别的手势是滑动手势时回调onFinger方法
            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                //得到手触碰位置的起始点和结束点坐标 x , y ，并进行计算
                val x = e2.x - e1.x
                val y = e2.y - e1.y
                //通过计算判断是向左还是向右滑动
                if (x > 0) {
                    count++
                    count %= dataList.size - 1        //想显示多少图片，就把定义图片的数组长度-1
                } else if (x < 0) {
                    count--
                    count = (count + (dataList.size - 1)) % (dataList.size - 1)
                }

                val bean = dataList.get(count) as SchoolSceneryBean
                //   Glide.with(this@ShowPictureActivity).load(bean.sceneryImgeurl).into(iv_school_scenery_big)  //切换imageView的图片
                Glide.with(this@ShowPictureActivity).load(R.drawable.bbbbb).into(iv_school_scenery_big)  //切换imageView的图片

                return true
            }
        }

        return onGestureListener
    }


}
