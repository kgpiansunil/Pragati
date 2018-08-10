package com.example.sunil.pragati.market;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.sunil.pragati.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BuyAndSell extends AppCompatActivity {


    private ListView mList;
    private DatabaseReference mDatabase;
    List<Purchase> purchaseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_and_sell);


        mList = (ListView) findViewById(R.id.user_list);
        mDatabase = FirebaseDatabase.getInstance().getReference("BuyAndSell");

        purchaseList = new ArrayList<>();



    }

    @Override
    protected void onStart() {
        super.onStart();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                purchaseList.clear();

                for (DataSnapshot farmerSnapshot : dataSnapshot.getChildren()){


                    Purchase purchase = farmerSnapshot.getValue(Purchase.class);
                    purchaseList.add(purchase);
                }

                PurchaseList adapter = new PurchaseList(BuyAndSell.this, purchaseList);
                mList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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

            Intent intent = new Intent(BuyAndSell.this, ProductDetails.class);
            startActivity(intent);
        }

        return true;
    }



}
