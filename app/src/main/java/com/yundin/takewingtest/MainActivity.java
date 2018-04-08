package com.yundin.takewingtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.yundin.takewingtest.listener.GestureListener;
import com.yundin.takewingtest.listener.HighlightGestureListener;
import com.yundin.takewingtest.listener.IDefaultValue;
import com.yundin.takewingtest.view.LockableNestedScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements IDefaultValue {

    float[][] data = new float[15][2];
    LockableNestedScrollView scrollView;
    LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = findViewById(R.id.scrollView);

        initData();
        initMPAndroidChart();
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
            data[i][0] = (float) i;
            data[i][1] = (new Random()).nextFloat();
        }
    }

    private void initMPAndroidChart() {
        chart = findViewById(R.id.MPAndroidChart);
        TextView tv = findViewById(R.id.MPAndroidChart_tv);
        List<Entry> entries = new ArrayList<>();

        for (float[] value : data) {
            entries.add(new Entry(value[0], value[1]));
        }

        LineDataSet dataSet = new LineDataSet(entries, null);
        //design dataSet
        dataSet.setDrawCircles(false);
        dataSet.setDrawHorizontalHighlightIndicator(false);
        //here bezier can be turned off
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        LineData lineData = new LineData(dataSet);
        //design lineData
        lineData.setDrawValues(false);

        //design chart
        chart.setDrawGridBackground(false);
        chart.setDrawBorders(false);
        chart.setData(lineData);
        chart.getDescription().setEnabled(false);
        chart.getXAxis().setEnabled(false);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        chart.getLegend().setEnabled(false);

        //chart abilities
        chart.setHighlightPerTapEnabled(false);
        chart.setScaleEnabled(false);

        //listeners
        chart.setOnChartValueSelectedListener(new HighlightGestureListener(tv, this));
        chart.setOnChartGestureListener(new GestureListener(scrollView, this));

        onSetDefaultValue();
        chart.invalidate();
    }

    @Override
    public void onSetDefaultValue() {
        chart.highlightValue(data[data.length - 1][0], data.length - 1, true);
    }

    @Override
    public float getDefaultValue() {
        return data[data.length - 1][1];
    }
}
