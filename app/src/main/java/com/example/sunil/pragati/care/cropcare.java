package com.example.sunil.pragati.care;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sunil.pragati.R;
import com.example.sunil.pragati.planning.SoilTestingManual;

public class cropcare extends AppCompatActivity {

    private CardView mLeafAnalysis;
    private CardView mNutrients;
    private Toolbar mToolbar;
    private String package_name= "org.tensorflow.demo";
    private String class_name= "org.tensorflow.demo.ClassifierActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropcare);


        mLeafAnalysis = (CardView)findViewById(R.id.leafanalysis);
        mNutrients = (CardView) findViewById(R.id.fertilizers);
        mToolbar = (Toolbar)findViewById(R.id.cropcareToolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mLeafAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cropcare.this, CropCareActivity.class);
                startActivity(intent);

             //   Intent intent = new Intent();
               // intent.setClassName("org.tensorflow.demo", "org.tensorflow.demo.ClassifierActivity");
                //startActivity(intent);


            }
        });

        mNutrients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cropcare.this, SoilTestingManual.class);
                startActivity(intent);
            }
        });


    }
}
