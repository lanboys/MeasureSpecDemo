package com.bing.lan.measurespecdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by 蓝兵 on 2017/12/29.
 */

public class WeChatImageView extends android.support.v7.widget.AppCompatImageView {

    private static final String TAG = "WeChatImageView";

    public WeChatImageView(Context context) {
        super(context);
    }

    public WeChatImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WeChatImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Log.i(TAG, "-------onSizeChanged--------------");
        Log.i(TAG, "w: " + w);
        Log.i(TAG, "h: " + h);
        Log.i(TAG, "-------onSizeChanged--------------");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "-------onDraw--------------");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        Log.i(TAG, "-------onMeasure--------------");
        Log.i(TAG, "widthSize: " + widthSize);
        Log.i(TAG, "heightSize: " + heightSize);
        Log.i(TAG, "-------onMeasure--------------");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.i(TAG, "------onLayout---------------");
        Log.i(TAG, "changed: " + changed);
        Log.i(TAG, "left: " + left);
        Log.i(TAG, "top: " + top);
        Log.i(TAG, "right: " + right);
        Log.i(TAG, "bottom: " + bottom);
        Log.i(TAG, "------onLayout---------------");
    }
}
