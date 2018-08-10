package com.example.sunil.pragati.planning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sunil.pragati.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PredictionReport extends AppCompatActivity {

    TextView mText;
    private BarChart barChart;
    String rain;
    String temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction_report);

        mText = (TextView)findViewById(R.id.yieldText);
        barChart = (BarChart) findViewById(R.id.myBarChart);

        float a = (float) 1128.44;
        rain = getIntent().getExtras().getString("rain");
        temp = getIntent().getExtras().getString("temp");


float b = Float.parseFloat(rain);
float c = Float.parseFloat(temp);

        float d = (float) (0.061 * b);
        float e = (float) (107*c);

  float yield = (d+e-a) ;

        String y = String.valueOf(yield);
       // Toast.makeText(this,y , Toast.LENGTH_SHORT).show();

        mText.setText(y);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1023, 0));
        barEntries.add(new BarEntry(880, 1));
        barEntries.add(new BarEntry(780, 2));
        barEntries.add(new BarEntry(920, 3));
        barEntries.add(new BarEntry(930, 4));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Years");


        ArrayList<String> theYears = new ArrayList<>();
        theYears.add("2012");
        theYears.add("2013");
        theYears.add("2014");
        theYears.add("2015");
        theYears.add("2016");

        BarData barData = new BarData(theYears, barDataSet);
        barChart.setData(barData);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);




    }
}
