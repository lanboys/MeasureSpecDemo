package com.bing.lan.measurespecdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蓝兵 on 2017/12/28.
 */

public class WeChatLayout extends ViewGroup {

    private static final String TAG = "WeChatLayout";

    private List<Integer> images = new ArrayList<>();

    public WeChatLayout(Context context) {
        super(context);
        init();
    }

    public WeChatLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WeChatLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        images.add(R.drawable.girl_1);
        images.add(R.drawable.girl_2);
        images.add(R.drawable.girl_2);
        images.add(R.drawable.girl_2);
        images.add(R.drawable.girl_1);
        images.add(R.drawable.girl_2);
        images.add(R.drawable.girl_2);
        images.add(R.drawable.girl_2);
        images.add(R.drawable.girl_1);

        initChildView();
    }

    private int mViewWidth;
    private int mViewHeight;

    private int mChildWidth;
    private int mChildHeight;

    private int mChildVerticalSpace = 40;
    private int mChildHorizontalSpace = 40;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        mViewWidth = w;
        mViewHeight = h;

        mChildWidth = (mViewWidth - mChildHorizontalSpace * 2) / 3;
        mChildHeight = (mViewHeight - mChildVerticalSpace * 2) / 3;

        Log.i(TAG, "-------onSizeChanged--------------");
        Log.i(TAG, "w: " + w);
        Log.i(TAG, "h: " + h);
        Log.i(TAG, "mChildWidth: " + mChildWidth);
        Log.i(TAG, "mChildHeight: " + mChildHeight);
        Log.i(TAG, "-------onSizeChanged--------------");

        post(new Runnable() {
            @Override
            public void run() {
                resetChildSize();
            }
        });
    }

    private void initChildView() {
        for (Integer image : images) {
            WeChatImageView imageView = new WeChatImageView(getContext());
            imageView.setImageResource(image);
            addView(imageView);
        }
    }

    private void resetChildSize() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            LayoutParams lp = child.getLayoutParams();
            lp.width = mChildWidth;
            lp.height = mChildHeight;
            child.setLayoutParams(lp);
            //child.requestLayout();
        }
    }

    public void startAnimator() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            ObjectAnimator rotation = ObjectAnimator.ofFloat(child, "rotation", -2, 2);
            rotation.setRepeatCount(ValueAnimator.INFINITE);
            rotation.setRepeatMode(ValueAnimator.REVERSE);
            rotation.setInterpolator(new LinearInterpolator());
            rotation.setDuration(30);
            rotation.start();
        }
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(mChildWidth, mChildHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.i(TAG, "-------onDraw--------------");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int count = getChildCount();

        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
        }

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        Log.i(TAG, "-------onMeasure--------------");
        Log.i(TAG, "widthSize: " + widthSize);
        Log.i(TAG, "heightSize: " + heightSize);
        Log.i(TAG, "-------onMeasure--------------");

        int height = 0;
        int width = 0;

        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;
            case MeasureSpec.AT_MOST:
                width = 1200;
                break;
            case MeasureSpec.UNSPECIFIED:
                width = widthSize;
                break;
            default:
                break;
        }
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            case MeasureSpec.AT_MOST:
                height = 1200;
                break;
            case MeasureSpec.UNSPECIFIED:
                height = heightSize;
                break;
            default:
                break;
        }

        setMeasuredDimension(MeasureSpec.makeMeasureSpec(width, widthMode),
                MeasureSpec.makeMeasureSpec(height, heightMode));

        // 或者通过如下方法设置
        //setMeasuredDimension(
        //        resolveSizeAndState(maxWidth, widthMeasureSpec, 0),
        //        resolveSizeAndState(maxHeight, heightMeasureSpec, 0));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        // 尺寸 是父控件 给子控件的布局坐标，坐标值是相对父控件 不是屏幕
        Log.i(TAG, "------onLayout---------------");
        Log.i(TAG, "changed: " + changed);
        Log.i(TAG, "left: " + left);
        Log.i(TAG, "top: " + top);
        Log.i(TAG, "right: " + right);
        Log.i(TAG, "bottom: " + bottom);
        Log.i(TAG, "------onLayout---------------");

        int widthUse = 0;
        int heightUse = 0;

        int maxHeight = 0;
        int maxWidth = 0;

        int count = getChildCount();

        for (int i = 0; i < count; i++) {

            //int childLeft = 0;
            //int childTop = 0;

            final View child = getChildAt(i);

            final int childMeasuredWidth = child.getMeasuredWidth();
            final int childMeasuredHeight = child.getMeasuredHeight();
            Log.i(TAG, "childMeasuredHeight: " + childMeasuredHeight);
            Log.i(TAG, "childMeasuredWidth: " + childMeasuredWidth);

            final MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            //maxWidth = Math.max(maxWidth, childMeasuredWidth + lp.leftMargin + lp.rightMargin);
            //maxHeight = Math.max(maxHeight, childMeasuredHeight + lp.topMargin + lp.bottomMargin);

            child.layout(widthUse, heightUse, widthUse + childMeasuredWidth, heightUse + childMeasuredHeight);

            widthUse += childMeasuredWidth + mChildHorizontalSpace;

            if (count == 4) {
                if (i % 2 == 1) {
                    widthUse = 0;
                }
            } else {
                if (i % 3 == 2) {
                    widthUse = 0;
                }
            }

            if (count == 4) {
                if (i % 2 == 1) {
                    heightUse += childMeasuredHeight + mChildVerticalSpace;
                }
            } else {
                if (i % 3 == 2) {
                    heightUse += childMeasuredHeight + mChildVerticalSpace;
                }
            }
        }
    }
}
