package com.example.sunil.pragati.market;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sunil.pragati.model.Farmers;
import com.example.sunil.pragati.adapter.FarmersList;
import com.example.sunil.pragati.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OtherFarmers extends AppCompatActivity {

    private ListView mList;
    private DatabaseReference mDatabase;
    List<Farmers> farmersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_farmers);

        mList = (ListView) findViewById(R.id.otherFarmersList);
        mDatabase = FirebaseDatabase.getInstance().getReference("farmers");

        farmersList = new ArrayList<>();


    }

    @Override
    protected void onStart() {
        super.onStart();

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                farmersList.clear();

                for (DataSnapshot farmerSnapshot : dataSnapshot.getChildren()){


                    Farmers farmers = farmerSnapshot.getValue(Farmers.class);
                    farmersList.add(farmers);
                }

                FarmersList adapter = new FarmersList(OtherFarmers.this, farmersList);
                mList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
