package com.mredrock.cyxbs.freshman.weight

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.freshman.R

class FreshmanBarGraghView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    View(context, attrs) {
    private var firstName: String? = null
    private var secondName: String? = null
    private var thirdName: String? = null
    private var firstPercent: Int ?=null
    private var secondPercent: Int ?=null
    private var thirdPercent: Int?=null
    private val paint: Paint
    private var width: Int ?=null
    private var height: Int ?=null
    private val color = intArrayOf(Color.parseColor("#698aff"), Color.parseColor("#ff95c3"),Color.parseColor("#71d5ff"))

    init {
        paint =Paint()
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        initAttrs(context, attrs)
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.textSize=35f
        canvas.drawText("2018 - 2019部分学科挂科率", (width!! * 0.1).toFloat(), (height!!*0.1).toFloat(),paint)
        paint.color=Color.parseColor("#5c7ffc")
        canvas.drawLine((width!! * 0.16).toFloat(), (height!! * 0.75).toFloat(),(width!! * 0.16).toFloat(), (height!! *0.23).toFloat(),paint)
        canvas.drawLine((width!! * 0.16).toFloat(), (height!! * 0.75).toFloat(),(width!!*0.9).toFloat(),(height!! * 0.75).toFloat(),paint)
        paint.textSize=20f
        canvas.drawText("挂",(width!! * 0.1).toFloat(), (height!!*0.27).toFloat(),paint)
        canvas.drawText("科",(width!! * 0.1).toFloat(), (height!!*0.30).toFloat(),paint)
        canvas.drawText("率",(width!! * 0.1).toFloat(), (height!!*0.33).toFloat(),paint)
        canvas.drawText("前",(width!! * 0.1).toFloat(), (height!!*0.36).toFloat(),paint)
        canvas.drawText("三",(width!! * 0.1).toFloat(), (height!!*0.39).toFloat(),paint)
        canvas.drawLine((width!! * 0.16).toFloat(), (height!! *0.23).toFloat(),((width!! * 0.16)+10).toFloat(), ((height!! *0.23)+10).toFloat(),paint)
        canvas.drawLine((width!! * 0.16).toFloat(), (height!! *0.23).toFloat(),((width!! * 0.16)-10).toFloat(), ((height!! *0.23)+10).toFloat(),paint)
        canvas.drawLine((width!!*0.9).toFloat(),(height!! * 0.75).toFloat(),((width!!*0.9)-10).toFloat(),((height!! * 0.75)+10).toFloat(),paint)
        canvas.drawLine((width!!*0.9).toFloat(),(height!! * 0.75).toFloat(),((width!!*0.9)-10).toFloat(),((height!! * 0.75)-10).toFloat(),paint)
        canvas.drawLine((width!! * 0.16).toFloat(), (height!! * 0.68).toFloat(),(width!! * 0.15).toFloat(), (height!! * 0.68).toFloat(),paint)
        canvas.drawLine((width!! * 0.16).toFloat(), (height!! * 0.61).toFloat(),(width!! * 0.15).toFloat(), (height!! * 0.61).toFloat(),paint)
        canvas.drawLine((width!! * 0.16).toFloat(), (height!! * 0.54).toFloat(),(width!! * 0.15).toFloat(), (height!! * 0.54).toFloat(),paint)
        canvas.drawLine((width!! * 0.16).toFloat(), (height!! * 0.47).toFloat(),(width!! * 0.15).toFloat(), (height!! * 0.47).toFloat(),paint)
        val firstRectF=RectF((width!! * 0.225).toFloat(),(width!! *0.76 - width!!*firstPercent!!*0.007).toFloat(),(width!! * 0.305).toFloat(),(height!! * 0.75).toFloat())
        val secondRectF=RectF((width!! * 0.465).toFloat(),(width!! *0.76 - width!!*secondPercent!!*0.007).toFloat(),(width!! * 0.545).toFloat(),(height!! * 0.75).toFloat())
        val thirdRectF=RectF((width!! * 0.705).toFloat(),(width!! *0.76 - width!!*thirdPercent!!*0.007).toFloat(),(width!! * 0.785).toFloat(),(height!! * 0.75).toFloat())
        canvas.drawText(firstName,(width!! * 0.22).toFloat(), (height!! *0.8).toFloat(),paint)
        canvas.drawText(secondName,(width!! * 0.47).toFloat(), (height!! *0.8).toFloat(),paint)
        canvas.drawText(thirdName,(width!! * 0.70).toFloat(), (height!! *0.8).toFloat(),paint)
        paint.color=color[0]
        canvas.drawRect(firstRectF,paint)
        paint.color=color[1]
        canvas.drawRect(secondRectF,paint)
        paint.color=color[2]
        canvas.drawRect(thirdRectF,paint)
        paint.color=Color.parseColor("#b0b1b3")
        canvas.drawText("$firstPercent%",(width!! * 0.24).toFloat(),(width!! *0.76 - width!!*firstPercent!!*0.007-width!!* 0.02).toFloat(),paint)
        canvas.drawText("$secondPercent%",(width!! * 0.48).toFloat(),(width!! *0.76 - width!!*secondPercent!!*0.007-width!!* 0.02).toFloat(),paint)
        canvas.drawText("$thirdPercent%",(width!! * 0.725).toFloat(),(width!! *0.76 - width!!*thirdPercent!!*0.007-width!!* 0.02).toFloat(),paint)
        paint.color=Color.parseColor("#5c7ffc")
        canvas.drawLine((width!! * 0.295).toFloat(),(width!! *0.76 - width!!*firstPercent!!*0.007+width!!*0.01).toFloat(),(width!! * 0.275).toFloat(),(width!! *0.76 - width!!*firstPercent!!*0.007+width!!*0.01).toFloat(),paint)
        canvas.drawLine((width!! * 0.295).toFloat(),(width!! *0.76 - width!!*firstPercent!!*0.007+width!!*0.01).toFloat(),(width!! * 0.295).toFloat(),(width!! *0.76 - width!!*firstPercent!!*0.007+width!!*0.03).toFloat(),paint)
        canvas.drawLine((width!! * 0.535).toFloat(),(width!! *0.76 - width!!*secondPercent!!*0.007+width!!*0.01).toFloat(),(width!! * 0.515).toFloat(),(width!! *0.76 - width!!*secondPercent!!*0.007+width!!*0.01).toFloat(),paint)
        canvas.drawLine((width!! * 0.535).toFloat(),(width!! *0.76 - width!!*secondPercent!!*0.007+width!!*0.01).toFloat(),(width!! * 0.535).toFloat(),(width!! *0.76 - width!!*secondPercent!!*0.007+width!!*0.03).toFloat(),paint)
        canvas.drawLine((width!! * 0.775).toFloat(),(width!! *0.76 - width!!*thirdPercent!!*0.007+width!!*0.01).toFloat(),(width!! * 0.755).toFloat(),(width!! *0.76 - width!!*thirdPercent!!*0.007+width!!*0.01).toFloat(),paint)
        canvas.drawLine((width!! * 0.775).toFloat(),(width!! *0.76 - width!!*thirdPercent!!*0.007+width!!*0.01).toFloat(),(width!! * 0.775).toFloat(),(width!! *0.76 - width!!*thirdPercent!!*0.007+width!!*0.03).toFloat(),paint)
        paint.style=Paint.Style.STROKE
        paint.color=Color.parseColor("#5c7ffc")
        canvas.drawRect(firstRectF,paint)
        canvas.drawRect(secondRectF,paint)
        canvas.drawRect(thirdRectF,paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w
        height = h
    }

    private fun initAttrs(context: Context, atts: AttributeSet?) {
        val ta = context.obtainStyledAttributes(atts, R.styleable.FreshmanBarGraghView)
        firstName = ta.getString(R.styleable.FreshmanBarGraghView_freshman_academy_name_first)
        secondName = ta.getString(R.styleable.FreshmanBarGraghView_freshman_academy_name_second)
        thirdName = ta.getString(R.styleable.FreshmanBarGraghView_freshman_academy_name_second)
        firstPercent = ta.getInt(R.styleable.FreshmanBarGraghView_freshman_academy_percent_first, 60)
        secondPercent = ta.getInt(R.styleable.FreshmanBarGraghView_freshman_academy_percent_second, 50)
        thirdPercent = ta.getInt(R.styleable.FreshmanBarGraghView_freshman_academy_percent_third, 40)
    }

    public fun setPercent(firstPercent :Int,secondPercent :Int,thirdPercent :Int){
        this.firstPercent=firstPercent
        this.secondPercent=secondPercent
        this.thirdPercent=thirdPercent
        invalidate()
    }

    public fun setName(firstName:String,secondName:String,thirdName:String){
        this.firstName=firstName
        this.secondName=secondName
        this.thirdName=thirdName
        invalidate()
    }
}
