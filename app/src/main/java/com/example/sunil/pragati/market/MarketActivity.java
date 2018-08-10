package com.example.sunil.pragati.market;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.sunil.pragati.R;

public class MarketActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;

    private CardView mBuySell;
    private CardView mKisanKendra;
    private CardView mInsurance;
    private CardView mOtherFarmers;
    private CardView mDerivative;
    private CardView mColdStorage;
    private CardView mPriceList;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.marketToolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mBuySell = (CardView) findViewById(R.id.buyandsell);
        mKisanKendra = (CardView) findViewById(R.id.kisankendra);
        mInsurance = (CardView) findViewById(R.id.insurance);
        mOtherFarmers = (CardView) findViewById(R.id.otherfarmers);
        mDerivative = (CardView) findViewById(R.id.derivative);
        mColdStorage = (CardView) findViewById(R.id.coldstorage);
        mPriceList = (CardView) findViewById(R.id.pricelist);





        mBuySell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarketActivity.this, BuyAndSell.class);
                startActivity(intent);
            }
        });

        mKisanKendra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarketActivity.this, KisanKendraMap.class);
                startActivity(intent);

            }
        });
        mInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mOtherFarmers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarketActivity.this, OtherFarmers.class);
                startActivity(intent);

            }
        });
        mDerivative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mColdStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarketActivity.this, ColdStorage.class);
                startActivity(intent);


            }
        });
        mPriceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MarketActivity.this, PriceList.class);
                startActivity(intent);



            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.market_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_add_details) {

            Intent intent = new Intent(MarketActivity.this, RegisterActivity.class);
            startActivity(intent);
        }

        return true;
    }
}