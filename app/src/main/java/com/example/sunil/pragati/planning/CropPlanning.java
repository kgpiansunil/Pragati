package com.example.sunil.pragati.planning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sunil.pragati.location.MyLocationUsingLocationAPI;
import com.example.sunil.pragati.R;
import com.example.sunil.pragati.care.pHActivity;

public class CropPlanning extends AppCompatActivity {

    private CardView mYield;
    private CardView mCropSeq;
    private CardView mClimate;
    private Toolbar mToolbar;
    private CardView mPh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_planning);

        mYield = (CardView) findViewById(R.id.yieldCard);
        mCropSeq = (CardView) findViewById(R.id.cropSeqCard);
        mClimate = (CardView) findViewById(R.id.climateCard);
        mPh = (CardView) findViewById(R.id.pHCard);
        mToolbar = (Toolbar) findViewById(R.id.cropplanningToolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mYield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CropPlanning.this, YieldPrediction.class);
                startActivity(intent);

            }
        });

        mPh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CropPlanning.this, pHActivity.class);
                startActivity(intent);

            }
        });

        mCropSeq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent cropseq_intent = new Intent(CropPlanning.this, CropSequencing.class);
                startActivity(cropseq_intent);



            }
        });

        mClimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent location_intent = new Intent(CropPlanning.this, MyLocationUsingLocationAPI.class);
                startActivity(location_intent);


            }
        });
    }


}
