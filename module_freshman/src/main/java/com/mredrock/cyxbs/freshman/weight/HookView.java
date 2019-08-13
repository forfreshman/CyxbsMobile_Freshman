package com.mredrock.cyxbs.freshman.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class HookView extends View {
    private int progress = 0;
    //线1的x轴
    private int line1_x = 0;
    //线1的y轴
    private int line1_y = 0;
    //线2的x轴
    private int line2_x = 0;
    //线2的y轴
    private int line2_y = 0;

    private int width,height;

    private Paint paint;
    private Paint textPanit;

    public HookView(Context context) {
        this(context,null);
    }

    public HookView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        textPanit=new Paint();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=w;
        height=h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        progress++;

        /**
         * 绘制圆弧
         */

        //设置画笔颜色
        paint.setColor(Color.parseColor("#87a3ff"));
        //设置圆弧的宽度
        paint.setStrokeWidth(10);
        //设置圆弧为空心
        paint.setStyle(Paint.Style.STROKE);
        //消除锯齿
        paint.setAntiAlias(true);

        //获取圆心的x坐标
        int centerX = getWidth() / 2;
        int centerY = getHeight()/2;
        int center1 = centerX - getWidth() / 20;
        //圆弧半径
        int radius = getHeight() /5;

        //定义的圆弧的形状和大小的界限
        RectF rectF = new RectF(centerX - radius, centerY - radius - height/10,centerX + radius , centerY + radius -height/10);

        //根据进度画圆弧
        canvas.drawArc(rectF, 235, -360 * progress / 100, false, paint);

        /**
         * 绘制对勾
         */
        //先等圆弧画完，才话对勾
        if(progress >= 100) {
            if(line1_x < radius / 3) {
                line1_x++;
                line1_y++;
            }
            //画第一根线
            canvas.drawLine(center1, height/2-height/10, center1 + line1_x, height/2 -height/10 + line1_y, paint);

            if (line1_x == radius / 3) {
                line2_x = line1_x;
                line2_y = line1_y;
                line1_x++;
                line1_y++;
            }
            if (line1_x >= radius / 3 && line2_x <= radius) {
                line2_x++;
                line2_y--;
            }
            //画第二根线
            canvas.drawLine(center1 + line1_x - 1, height/2 -height/10 + line1_y, center1 + line2_x, height/2-height/10 + line2_y, paint);

        }
        //画文字

            textPanit.setStyle(Paint.Style.FILL);
            textPanit.setColor(Color.parseColor("#87a3ff"));
            textPanit.setTextSize(60);
            canvas.drawText("复制成功",centerX -radius - getWidth()/20,centerY + radius+getHeight()/10,textPanit);

        //每隔10毫秒界面刷新
        postInvalidateDelayed((long) 0.001);
    }

}
