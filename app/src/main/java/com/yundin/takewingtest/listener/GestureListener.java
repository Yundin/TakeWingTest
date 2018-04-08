package com.yundin.takewingtest.listener;

import android.view.MotionEvent;

import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.yundin.takewingtest.view.LockableNestedScrollView;

/**
 * @author Yundin Vladislav
 */
public class GestureListener implements OnChartGestureListener {

    private LockableNestedScrollView scrollView;
    private IDefaultValue listener;

    public GestureListener(LockableNestedScrollView scrollView, IDefaultValue listener) {
        this.scrollView = scrollView;
        this.listener = listener;
    }

    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        scrollView.setScrollingEnabled(false);
    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        listener.onSetDefaultValue();
        scrollView.setScrollingEnabled(true);
    }

    @Override
    public void onChartLongPressed(MotionEvent me) {

    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {

    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {

    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {

    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {

    }
}