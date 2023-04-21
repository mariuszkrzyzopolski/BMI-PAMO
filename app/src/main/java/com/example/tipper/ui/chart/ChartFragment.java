package com.example.tipper.ui.chart;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.tipper.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

public class ChartFragment extends Fragment {

    private ChartViewModel mViewModel;
    private BarChart barchart;

    public static ChartFragment newInstance() {
        return new ChartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                              @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chart, container, false);
        barchart = new BarChart(getActivity());
        mViewModel = new ChartViewModel();
        FrameLayout chart = v.findViewById(R.id.chartLayout);
        BarData data = new BarData(mViewModel.getDataSet());
        data.setBarWidth(0.9f);
        barchart.setData(data);
        chart.addView(barchart);


        return v;
    }
}