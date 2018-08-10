package com.example.sunil.pragati.market;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sunil.pragati.model.Farmers;
import com.example.sunil.pragati.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText mName;
    private  EditText mContact;
    private Button mSubmitBtn;
    private Spinner mSpinner;
    private EditText mAdd;
    private EditText mVillage;

    DatabaseReference mDatabase;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mName = (EditText) findViewById(R.id.userName);
        mContact = (EditText) findViewById(R.id.contact);
        mSubmitBtn =(Button) findViewById(R.id.reg_btn);
        mSpinner = (Spinner) findViewById(R.id.farmerSpinner);
        mAdd = (EditText)findViewById(R.id.userAdd);
        mVillage = (EditText) findViewById(R.id.userVillage);
        mDatabase = FirebaseDatabase.getInstance().getReference("farmers");

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(RegisterActivity.this);
                progressDialog.setTitle("Adding Data");
                progressDialog.setMessage("Please Wait....");
                progressDialog.show();

                addFarmer();


            }
        });
    }

    private void addFarmer(){

        String name = mName.getText().toString().trim();
        String contact = mContact.getText().toString().trim();
        String type = mSpinner.getSelectedItem().toString();
        String add = mAdd.getText().toString().trim();
        String village = mVillage.getText().toString().trim();


        if (!TextUtils.isEmpty(name)) {

         String id =   mDatabase.push().getKey();

         Farmers farmers = new Farmers(id, name, contact, type, add, village);

         mDatabase.child(id).setValue(farmers);
            Toast.makeText(this, "Details Successfully Added", Toast.LENGTH_SHORT).show();
         progressDialog.dismiss();
            Intent intent = new Intent(RegisterActivity.this, MarketActivity.class);
            startActivity(intent);
            finish();



        }else {
            Toast.makeText(this, "Enter details", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

        }
    }
}
