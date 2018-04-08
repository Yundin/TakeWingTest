package com.yundin.takewingtest.listener;

import android.widget.TextView;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

/**
 * @author Yundin Vladislav
 */
public class HighlightGestureListener implements OnChartValueSelectedListener {

    private TextView tv;
    private IDefaultValue listener;

    public HighlightGestureListener(TextView tv, IDefaultValue listener) {
        this.tv = tv;
        this.listener = listener;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        tv.setText(String.valueOf(e.getY()));
    }

    @Override
    public void onNothingSelected() {
        tv.setText(String.valueOf(listener.getDefaultValue()));
    }
}
