package com.example.sunil.pragati.planning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sunil.pragati.R;

public class YieldPrediction extends AppCompatActivity {

   private EditText mRain;
   private  EditText mTemp;
   private Button submit;
    private String rain;
    private EditText eiteText;
    private EditText eiteText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yield_prediction);

     //   mRain = (EditText) findViewById(R.id.avgRain);
        mTemp = (EditText) findViewById(R.id.minTemp);
        submit = (Button) findViewById(R.id.submit);
      //   rain = mRain.getText().toString();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                eiteText=(EditText)findViewById(R.id.avgRain);
                String result=eiteText.getText().toString();

                eiteText2=(EditText)findViewById(R.id.minTemp);
                String result2=eiteText.getText().toString();

                Intent intent = new Intent(YieldPrediction.this, PredictionReport.class);
                intent.putExtra("rain", result);
                intent.putExtra("temp", result2);
                startActivity(intent);

            }
        });

    }
}
