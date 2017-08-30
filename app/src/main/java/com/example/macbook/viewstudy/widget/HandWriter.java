package com.example.macbook.viewstudy.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.example.macbook.viewstudy.R;

/**
 * Created by renxiaofeng on 16/7/31.
 */
public class HandWriter extends View{

    private int pathColor;
    private int pathWidth;
    private int background;

    private Paint paint;
    private Path path;
    private Canvas canvas;


    public HandWriter(Context context) {
        this(context, null);
    }


    public HandWriter(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public HandWriter(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.HandWriter);
        pathColor = a.getColor(R.styleable.HandWriter_pathColor,getResources().getColor(R.color.colorPrimaryDark));
        pathWidth = a.getDimensionPixelSize(R.styleable.HandWriter_pathWidth, 0);
        a.recycle();

        setBackgroundColor(background);
        paint = new Paint();
        paint.setColor(pathColor);
        paint.setStrokeWidth(pathWidth);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        path = new Path();
        canvas = new Canvas();
    }


    @Override public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX,touchY);
                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }


    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }
}
