package com.example.sunil.pragati;

import android.annotation.SuppressLint;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;



public class VolleySingleton {

    @SuppressLint("StaticFieldLeak")
    private static VolleySingleton volleySingleton;
    private static RequestQueue requestQueue;
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    private VolleySingleton(Context context) {
        VolleySingleton.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (volleySingleton == null) {
            volleySingleton = new VolleySingleton(context);
        }
        return volleySingleton;
    }


    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

   /* public <T> void addToRequestQueue(Request request) {
        requestQueue.add(request);
    }*/

}