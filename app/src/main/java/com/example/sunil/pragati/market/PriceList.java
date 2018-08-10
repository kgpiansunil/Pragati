package com.example.sunil.pragati.market;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sunil.pragati.R;

public class PriceList extends AppCompatActivity {

    private WebView mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_list);


        mView = (WebView) findViewById(R.id.web);
        mView.setWebViewClient(new WebViewClient());
        mView.loadUrl("http://agmarknet.nic.in/rep1Newx1_today.asp");

    }
}
