package com.mredrock.cyxbs.freshman.weight

<<<<<<< HEAD
import android.animation.ValueAnimator
=======
>>>>>>> upstream/master
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.mredrock.cyxbs.freshman.R

import java.text.DecimalFormat

class FreshmanPieView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {
    private val color = intArrayOf(Color.parseColor("#71d5ff"), Color.parseColor("#ff95c3"))
    //颜色（男，女）
    private var title: String? = null
<<<<<<< HEAD
    private var maleAngle: Float? = null
    private var femaleAngle: Float? = null
    private var malePercent: Float? = null
    private var femalePercent: Float? = null
=======
    private var maleAngle: Float ?=null
    private var femaleAngle: Float ?=null
    private var malePercent: Float ?=null
    private var femalePercent: Float?=null
>>>>>>> upstream/master
    private val startAngle = 90f
    private val paint: Paint
    private var width: Int? = null
    private var height: Int? = null
    private var male: String? = null
    private var female: String? = null
<<<<<<< HEAD
    val decimalFormat = DecimalFormat(".0")
=======
>>>>>>> upstream/master

    init {
        paint = Paint()
        paint.style = Paint.Style.FILL
        paint.isAntiAlias = true
        initAttrs(context, attrs)
<<<<<<< HEAD
//        val valueAnimator =ValueAnimator.ofFloat(0F, 360F)
//        valueAnimator.setDuration(1000)
//        valueAnimator.addUpdateListener(object :ValueAnimator.AnimatorUpdateListener{
//
//            override fun onAnimationUpdate(p0: ValueAnimator?) {
//                currentStartAngle= valueAnimator.getAnimatedValue() as Float + startAngle
//                invalidate()
//            }
//        })
//        valueAnimator.start()
=======
>>>>>>> upstream/master
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.FreshmanPieView)
        malePercent = ta.getFloat(R.styleable.FreshmanPieView_freshman_male_percent, 50f)
        femalePercent = ta.getFloat(R.styleable.FreshmanPieView_freshman_female_percent, 50f)
        title = ta.getString(R.styleable.FreshmanPieView_freshman_academy)
<<<<<<< HEAD


=======
        maleAngle = 360 * (malePercent!! / 100)
        femaleAngle = 360 * (femalePercent!! / 100)
        val decimalFormat = DecimalFormat(".0")
        male = decimalFormat.format(malePercent!!.toDouble())
        female = decimalFormat.format(femalePercent!!.toDouble())
>>>>>>> upstream/master
        ta.recycle()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w
        height = h
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
<<<<<<< HEAD
        val angles = arrayListOf(maleAngle, femaleAngle)
        val raduis = (width!! / 4).toFloat()

        paint.color = Color.parseColor("#333333")
        paint.textSize = 35f
        canvas.drawText(title!! + "男女比例", (width!! * 0.1).toFloat(), (height!! * 0.1).toFloat(), paint)
        paint.color = Color.parseColor("#5c7ffc")
        paint.textSize = 28f
=======
        val raduis = (width!! / 4).toFloat()
        var currentStartAngle = startAngle
        paint.color = Color.parseColor("#333333")
        paint.textSize = 25f
        canvas.drawText(title!! + "男女比例", (width!! * 0.1).toFloat(), (height!! * 0.1).toFloat(), paint)
        paint.color = Color.parseColor("#5c7ffc")
        paint.textSize = 18f
>>>>>>> upstream/master
        canvas.drawText("男", (width!! * 0.17).toFloat(), (height!! * 0.23).toFloat(), paint)
        canvas.drawText("女", (width!! * 0.17).toFloat(), (height!! * 0.33).toFloat(), paint)
        val femaleRectF = RectF(
            (width!! / 10).toFloat(),
            (height!! * 0.3).toFloat(),
            (width!! * 0.16).toFloat(),
            (height!! * 0.34).toFloat()
        )

        val maleRectF = RectF(
            (width!! / 10).toFloat(),
            (height!! / 5).toFloat(),
            (width!! * 0.16).toFloat(),
            (height!! * 0.24).toFloat()
        )
        paint.style = Paint.Style.STROKE
        paint.color = Color.parseColor("#698aff")
        canvas.drawRect(maleRectF, paint)
        canvas.drawRect(femaleRectF, paint)
        paint.style = Paint.Style.FILL
        paint.color = color[1]
        canvas.drawRect(femaleRectF, paint)
        paint.color = color[0]
        canvas.drawRect(maleRectF, paint)
        val pieRectf = RectF(
            (width!! / 4).toFloat(),
            (height!! * 0.36).toFloat(),
            (width!! * 0.76).toFloat(),
            (height!! * 0.9).toFloat()
        )

<<<<<<< HEAD
//        fun shezhi(canvas: Canvas,n : Int,paint: Paint){
//            for (i in 0 .. n){
//                paint.color=color[n]
//                canvas.drawArc(pieRectf, angles[n]!!, currentStartAngle!! - angles[n]!!,true,paint)
//            }
//        }
        var currentStartAngle = startAngle
        paint.style = Paint.Style.FILL
//        if (currentStartAngle!! < angles[1]!!){
//            shezhi(canvas,0,paint)
//        }else {
//            shezhi(canvas,1,paint)
//        }
=======
        paint.style = Paint.Style.FILL
>>>>>>> upstream/master
        paint.color = color[0]
        canvas.drawArc(pieRectf, currentStartAngle, maleAngle!!, true, paint)
        paint.color = color[1]
        currentStartAngle += maleAngle!!
        canvas.drawArc(pieRectf, currentStartAngle, femaleAngle!!, true, paint)
        paint.color = Color.parseColor("#698aff")
        canvas.drawLine(
            (width!! * 0.505).toFloat(),
            (height!! * 0.63).toFloat(),
            (width!! * 0.505).toFloat(),
            (height!! * 0.9).toFloat()
            , paint
        )
        canvas.drawLine(
            (width!! * 0.505).toFloat(),
            (height!! * 0.63).toFloat(),
<<<<<<< HEAD
            ((width!! * 0.505) + raduis * Math.sin(femaleAngle!! * Math.PI / 180)).toFloat(),
            ((height!! * 0.63) + raduis * Math.cos(femaleAngle!! * Math.PI / 180)).toFloat(),
=======
            ((width!! * 0.505)+raduis * Math.sin(femaleAngle!! * Math.PI / 180)).toFloat(),
            ((height!! * 0.63)+ raduis * Math.cos(femaleAngle!! * Math.PI / 180)).toFloat(),
>>>>>>> upstream/master
            paint
        )
        paint.style = Paint.Style.STROKE
        canvas.drawArc(pieRectf, startAngle, 360f, true, paint)
        paint.style = Paint.Style.FILL
<<<<<<< HEAD
        paint.textSize = 30f
        paint.color = Color.parseColor("#ffffff")
        canvas.drawText(male!! + "%", (width!! * 0.4).toFloat(), (height!! / 2).toFloat(), paint)
        canvas.drawText(female!! + "%", (width!! * 0.53).toFloat(), (height!! * 0.85).toFloat(), paint)
=======
        paint.textSize = 20f
        paint.color = Color.parseColor("#ffffff")
        canvas.drawText(male!! + "%", (width!! * 0.4).toFloat(), (height!! / 2).toFloat(), paint)
        canvas.drawText(female!! + "%", (width!! * 0.55).toFloat(), (height!! * 0.85).toFloat(), paint)
>>>>>>> upstream/master

    }

    fun setTitle(title: String) {
        this.title = title
    }

<<<<<<< HEAD
    fun setMalePercent(malePercent: Double) {
        this.malePercent = malePercent.toFloat()
        male = decimalFormat.format(malePercent!!.toDouble())
        maleAngle = 360 * (this.malePercent!! / 100)
        invalidate()
    }

    fun setFemalePercent(femalePercent: Double) {
        this.femalePercent = femalePercent.toFloat()
        female = decimalFormat.format(femalePercent!!.toDouble())
        femaleAngle = 360 * (this.femalePercent!! / 100)
        invalidate()
    }


=======
    fun setMalePercent(malePercent: Int) {
        this.malePercent = malePercent.toFloat()
        invalidate()
    }

    fun setFemalePercent(femalePercent: Int) {
        this.femalePercent = femalePercent.toFloat()
        invalidate()
    }

>>>>>>> upstream/master
}
