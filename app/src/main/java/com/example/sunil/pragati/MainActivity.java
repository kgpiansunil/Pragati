package com.example.sunil.pragati;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.sunil.pragati.care.cropcare;
import com.example.sunil.pragati.market.MarketActivity;
import com.example.sunil.pragati.planning.CropPlanning;

public class MainActivity extends AppCompatActivity  {

    private TextView mPlanningText;
    private TextView mCareText;
    private TextView mMarketText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlanningText = (TextView) findViewById(R.id.planning_text);
        mCareText = (TextView) findViewById(R.id.care_text);
        mMarketText = (TextView) findViewById(R.id.market_text);

        mPlanningText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent planning_intent = new Intent(MainActivity.this, CropPlanning.class);
                startActivity(planning_intent);


            }
        });

        mMarketText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent market_intent = new Intent(MainActivity.this, MarketActivity.class);
                startActivity(market_intent);
            }
        });

        mCareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent care_intent = new Intent(MainActivity.this, cropcare.class);
                startActivity(care_intent);
            }
        });

    }
}
