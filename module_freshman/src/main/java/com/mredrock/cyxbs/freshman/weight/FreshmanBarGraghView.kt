package com.mredrock.cyxbs.freshman.weight

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.mredrock.cyxbs.freshman.R
import java.text.DecimalFormat

class FreshmanBarGraghView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    View(context, attrs) {
    private var firstName: String = ""
    private var secondName: String =""
    private var thirdName: String = ""
    private var firstPercent: Float =0f
    private var secondPercent: Float =0f
    private var thirdPercent: Float=0f
    private val paint: Paint
    private var mWidth: Int = 0
    private var mHeight: Int =0
    private var first :String=""
    private var second :String=""
    private var third :String=""
    private val color = intArrayOf(Color.parseColor("#698aff"), Color.parseColor("#ff95c3"),Color.parseColor("#71d5ff"))

    init {
        paint =Paint()
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        initAttrs(context, attrs)
        val decimalFormat = DecimalFormat("#.00")
        first = decimalFormat.format(firstPercent.toDouble())
        second=decimalFormat.format(secondPercent.toDouble())
        third=decimalFormat.format(thirdPercent.toDouble())
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color=Color.parseColor("#5c7ffc")
        canvas.drawLine((mWidth * 0.16).toFloat(), (mHeight * 0.75).toFloat(),(mWidth * 0.16).toFloat(), (mHeight *0.23).toFloat(),paint)
        canvas.drawLine((mWidth * 0.16).toFloat(), (mHeight * 0.75).toFloat(),(mWidth*0.9).toFloat(),(mHeight * 0.75).toFloat(),paint)
        paint.textSize=26f
        canvas.drawText("难",(mWidth * 0.1).toFloat(), (mHeight*0.27).toFloat(),paint)
        canvas.drawText("度",(mWidth * 0.1).toFloat(), (mHeight*0.32).toFloat(),paint)
        canvas.drawText("系",(mWidth * 0.1).toFloat(), (mHeight*0.37).toFloat(),paint)
        canvas.drawText("数",(mWidth * 0.1).toFloat(), (mHeight*0.42).toFloat(),paint)
        canvas.drawLine((mWidth * 0.16).toFloat(), (mHeight *0.23).toFloat(),((mWidth * 0.16)+10).toFloat(), ((mHeight *0.23)+10).toFloat(),paint)
        canvas.drawLine((mWidth * 0.16).toFloat(), (mHeight *0.23).toFloat(),((mWidth * 0.16)-10).toFloat(), ((mHeight *0.23)+10).toFloat(),paint)
        canvas.drawLine((mWidth*0.9).toFloat(),(mHeight * 0.75).toFloat(),((mWidth*0.9)-10).toFloat(),((mHeight * 0.75)+10).toFloat(),paint)
        canvas.drawLine((mWidth*0.9).toFloat(),(mHeight * 0.75).toFloat(),((mWidth*0.9)-10).toFloat(),((mHeight * 0.75)-10).toFloat(),paint)
        canvas.drawLine((mWidth * 0.16).toFloat(), (mHeight * 0.68).toFloat(),(mWidth * 0.15).toFloat(), (mHeight * 0.68).toFloat(),paint)
        canvas.drawLine((mWidth * 0.16).toFloat(), (mHeight * 0.61).toFloat(),(mWidth * 0.15).toFloat(), (mHeight * 0.61).toFloat(),paint)
        canvas.drawLine((mWidth * 0.16).toFloat(), (mHeight * 0.54).toFloat(),(mWidth * 0.15).toFloat(), (mHeight * 0.54).toFloat(),paint)
        canvas.drawLine((mWidth * 0.16).toFloat(), (mHeight * 0.47).toFloat(),(mWidth * 0.15).toFloat(), (mHeight * 0.47).toFloat(),paint)
        val firstRectF=RectF((mWidth * 0.225).toFloat(),(mWidth *0.76 - mWidth*firstPercent*0.7).toFloat(),(mWidth * 0.305).toFloat(),(mHeight!! * 0.75).toFloat())
        val secondRectF=RectF((mWidth * 0.465).toFloat(),(mWidth *0.76 - mWidth*secondPercent*0.7).toFloat(),(mWidth * 0.545).toFloat(),(mHeight!! * 0.75).toFloat())
        val thirdRectF=RectF((mWidth * 0.705).toFloat(),(mWidth *0.76 - mWidth*thirdPercent*0.7).toFloat(),(mWidth * 0.785).toFloat(),(mHeight!! * 0.75).toFloat())
        canvas.drawText(firstName,(mWidth * 0.16).toFloat(), (mHeight *0.8).toFloat(),paint)
        canvas.drawText(secondName,(mWidth * 0.43).toFloat(), (mHeight *0.8).toFloat(),paint)
        canvas.drawText(thirdName,(mWidth * 0.69).toFloat(), (mHeight *0.8).toFloat(),paint)
        paint.color=color[0]
        canvas.drawRect(firstRectF,paint)
        paint.color=color[1]
        canvas.drawRect(secondRectF,paint)
        paint.color=color[2]
        canvas.drawRect(thirdRectF,paint)
        paint.color=Color.parseColor("#b0b1b3")
        canvas.drawText("0$first",(mWidth * 0.23).toFloat(),(mWidth *0.76 - mWidth*firstPercent*0.7-mWidth* 0.02).toFloat(),paint)
        canvas.drawText("0$second",(mWidth * 0.47).toFloat(),(mWidth *0.76 - mWidth*secondPercent*0.7-mWidth* 0.02).toFloat(),paint)
        canvas.drawText("0$third",(mWidth * 0.715).toFloat(),(mWidth *0.76 - mWidth*thirdPercent*0.7-mWidth* 0.02).toFloat(),paint)
        paint.color=Color.parseColor("#5c7ffc")
        canvas.drawLine((mWidth * 0.295).toFloat(),(mWidth *0.76 - mWidth*firstPercent*0.7+mWidth*0.01).toFloat(),(mWidth * 0.275).toFloat(),(mWidth!! *0.76 - mWidth!!*firstPercent!!*0.7+mWidth!!*0.01).toFloat(),paint)
        canvas.drawLine((mWidth * 0.295).toFloat(),(mWidth *0.76 - mWidth*firstPercent*0.7+mWidth*0.01).toFloat(),(mWidth * 0.295).toFloat(),(mWidth!! *0.76 - mWidth!!*firstPercent!!*0.7+mWidth!!*0.03).toFloat(),paint)
        canvas.drawLine((mWidth * 0.535).toFloat(),(mWidth *0.76 - mWidth*secondPercent*0.7+mWidth*0.01).toFloat(),(mWidth * 0.515).toFloat(),(mWidth!! *0.76 - mWidth!!*secondPercent!!*0.7+mWidth!!*0.01).toFloat(),paint)
        canvas.drawLine((mWidth * 0.535).toFloat(),(mWidth *0.76 - mWidth*secondPercent*0.7+mWidth*0.01).toFloat(),(mWidth * 0.535).toFloat(),(mWidth!! *0.76 - mWidth!!*secondPercent!!*0.7+mWidth!!*0.03).toFloat(),paint)
        canvas.drawLine((mWidth * 0.775).toFloat(),(mWidth *0.76 - mWidth*thirdPercent*0.7+mWidth*0.01).toFloat(),(mWidth * 0.755).toFloat(),(mWidth!! *0.76 - mWidth!!*thirdPercent!!*0.7+mWidth!!*0.01).toFloat(),paint)
        canvas.drawLine((mWidth * 0.775).toFloat(),(mWidth *0.76 - mWidth*thirdPercent*0.7+mWidth*0.01).toFloat(),(mWidth * 0.775).toFloat(),(mWidth!! *0.76 - mWidth!!*thirdPercent!!*0.7+mWidth!!*0.03).toFloat(),paint)
        paint.style=Paint.Style.STROKE
        paint.color=Color.parseColor("#5c7ffc")
        canvas.drawRect(firstRectF,paint)
        canvas.drawRect(secondRectF,paint)
        canvas.drawRect(thirdRectF,paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
    }

    @SuppressLint("Recycle")
    private fun initAttrs(context: Context, atts: AttributeSet?) {
        val ta = context.obtainStyledAttributes(atts, R.styleable.FreshmanBarGraghView)
        firstName = ta.getString(R.styleable.FreshmanBarGraghView_freshman_academy_name_first)
        secondName = ta.getString(R.styleable.FreshmanBarGraghView_freshman_academy_name_second)
        thirdName = ta.getString(R.styleable.FreshmanBarGraghView_freshman_academy_name_second)
        firstPercent = ta.getFloat(R.styleable.FreshmanBarGraghView_freshman_academy_percent_first, 0.6f)
        secondPercent = ta.getFloat(R.styleable.FreshmanBarGraghView_freshman_academy_percent_second, 0.5f)
        thirdPercent = ta.getFloat(R.styleable.FreshmanBarGraghView_freshman_academy_percent_third, 0.4f)
    }

    fun set(firstPercent :Double,secondPercent :Double,thirdPercent :Double){
        this.firstPercent=firstPercent.toFloat()
        this.secondPercent=secondPercent.toFloat()
        this.thirdPercent=thirdPercent.toFloat()
        val decimalFormat = DecimalFormat("#.00")
        first = decimalFormat.format(firstPercent)
        second=decimalFormat.format(secondPercent)
        third=decimalFormat.format(thirdPercent)
        invalidate()
        Log.d("AAA:","aaa")
    }

    fun setName(firstName:String,secondName:String,thirdName:String){
        this.firstName=firstName
        this.secondName=secondName
        this.thirdName=thirdName
        invalidate()
    }
}
