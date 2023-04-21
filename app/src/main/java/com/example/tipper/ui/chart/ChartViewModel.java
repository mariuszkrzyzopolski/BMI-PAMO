package com.example.tipper.ui.chart;

import android.graphics.Color;

import androidx.lifecycle.ViewModel;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class ChartViewModel extends ViewModel {
    private ArrayList dataSets;
    private ArrayList xAxis;

    public ChartViewModel() {
        setDataSet();
    }

    void setDataSet() {
        xAxis = new ArrayList();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");

        ArrayList valueSet1 = new ArrayList();
        BarEntry v1e1 = new BarEntry(0,19.1f); // Jan
        valueSet1.add(v1e1);

        BarEntry v1e2 = new BarEntry(1,19.2f); // Feb
        valueSet1.add(v1e2);

        BarEntry v1e3 = new BarEntry(2,19.5f); // Mar
        valueSet1.add(v1e3);

        BarEntry v1e4 = new BarEntry(3,20.1f); // Apr
        valueSet1.add(v1e4);

        BarEntry v1e5 = new BarEntry(4,19.6f); // May
        valueSet1.add(v1e5);

        BarEntry v1e6 = new BarEntry(5,20.2f); // Jun
        valueSet1.add(v1e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "BMI");
        barDataSet1.setColor(Color.rgb(0, 155, 0));

        dataSets = new ArrayList();
        dataSets.add(barDataSet1);
    }

    ArrayList getDataSet(){
        return dataSets;
    }
}