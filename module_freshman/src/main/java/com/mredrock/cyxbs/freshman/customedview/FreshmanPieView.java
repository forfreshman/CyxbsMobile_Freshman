package com.mredrock.cyxbs.freshman.customedview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

public class FreshmanPieView extends View {
    private int[] color = {Color.parseColor("#ff95c3"),Color.parseColor("#71d5ff")};
     //颜色（女，男）
    private float startAngle = -90;
    private Paint paint;
    private int width,height;

    public FreshmanPieView(Context context) {
        this(context,null);
    }

    public FreshmanPieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint=new Paint();
        paint.setStyle();
    }

}
