package com.mredrock.cyxbs.freshman.weight

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

/**
 * created by chenyang
 * on 2019/8/12
 */
 class RotateImageview : AppCompatImageView {

    var degree = 0//转动的角度
    var m = Matrix()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {

        canvas.concat(m)
        val drawable = drawable ?: return

        if (width == 0 || height == 0) {
            return
        }

        val b = (drawable as BitmapDrawable).bitmap
        val bitmap = b.copy(Bitmap.Config.ARGB_8888, true)

        val radius = width
        val h = height

        val roundBitmap = getCroppedBitmap(bitmap, radius)
        canvas.drawBitmap(roundBitmap, 0f, 0f, null)
        m.reset()
        m.postRotate((degree++ % 360).toFloat(), (radius / 2).toFloat(), (radius / 2).toFloat())
        invalidate()
    }

    companion object {


        fun getCroppedBitmap(bitmap: Bitmap, radius: Int): Bitmap {

            var sbitmap: Bitmap? = null
            if (bitmap.width != radius || bitmap.height != radius) {
                val smallest = Math.min(bitmap.width, bitmap.height).toFloat()
                val factor = smallest / radius
                sbitmap = Bitmap.createScaledBitmap(
                    bitmap,
                    (bitmap.width / factor).toInt(),
                    (bitmap.height / factor).toInt(),
                    false
                )
            } else {
                sbitmap = bitmap
            }

            val output = Bitmap.createBitmap(radius, radius, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(output)
            val paint = Paint()
            val rect = Rect(0, 0, radius, radius)

            paint.isAntiAlias = true
            paint.isFilterBitmap = true
            paint.isDither = true
            paint.color = Color.parseColor("#BAB399")

            canvas.drawCircle(
                radius / 2 + 0.7f,
                radius / 2 + 0.7f,
                radius / 2 + 0.1f, paint
            )

            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
            canvas.drawBitmap(sbitmap!!, rect, rect, paint)

            return output
        }
    }
}
