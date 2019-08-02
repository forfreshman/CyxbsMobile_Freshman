package com.mredrock.cyxbs.freshman.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.mredrock.cyxbs.freshman.R;

public class CursorView extends View {
    private int cursorColor = getResources().getColor(R.color.colorPrimary); // 线的颜色
    private int counts = 4; // 被分成了几块
    private float posX = 0f; // 当前X坐标的位置
    private Paint paint;

    public CursorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CursorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CursorView(Context context) {
        super(context);
        init();
    }

    private void init() {
        // 初始化画笔
        paint = new Paint();
        paint.setAntiAlias(true);//边缘相对清晰一点,锯齿痕迹不那么明显
        paint.setDither(true);//设置防抖动
        paint.setColor(cursorColor);//画笔颜色
    }

    /**
     * 设置ViewPager的下划线总共有几条
     * @param counts
     */
    public void setCounts(int counts) {
        this.counts = counts;
    }

    /**
     * 设置下滑的颜色
     * @param cursorColor
     */
    public void setColor(int cursorColor) {
        this.cursorColor = cursorColor;
    }

    /**
     * 设置坐标，
     * 该方法在viewpager绑定监听事件的onPageScrolled(int arg0, float arg1, int arg2) 方法中调用
     * @param pos 当前的item，上面的arg0参数
     * @param rate 变化率，为上面的arg0
     */
    public void setXY(int pos, float rate) {
        int single = getMeasuredWidth() / counts;
        posX = pos * single + single * rate;
        invalidate();//重新绘制
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStrokeWidth(getMeasuredHeight()+5);
        int width = getMeasuredWidth() / counts;//下划线长度
        canvas.drawLine(posX, 0, posX + width, 0, paint);
    }

}
