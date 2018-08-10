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

import com.example.sunil.pragati.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProductDetails extends AppCompatActivity {

    private EditText mName;
    private  EditText mContact;
    private  EditText mPrice;
    private Button mSubmitBtn;
    private Spinner mSpinner;

    DatabaseReference mDatabase;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        mName = (EditText) findViewById(R.id.userName);
        mPrice = (EditText) findViewById(R.id.userPrice);
        mContact = (EditText) findViewById(R.id.contact);
        mSubmitBtn =(Button) findViewById(R.id.reg_btn);
        mSpinner = (Spinner) findViewById(R.id.farmerSpinner);
        mDatabase = FirebaseDatabase.getInstance().getReference("BuyAndSell");


        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(ProductDetails.this);
                progressDialog.setTitle("Adding Data");
                progressDialog.setMessage("Please Wait....");
                progressDialog.show();

                addSell();


            }
        });

    }

    private void addSell(){

        String name = mName.getText().toString().trim();
        String contact = mContact.getText().toString().trim();
        String price = mPrice.getText().toString().trim();
        String type = mSpinner.getSelectedItem().toString();


        if (!TextUtils.isEmpty(name)) {

            String id =   mDatabase.push().getKey();

            Purchase purchase = new Purchase(id, name, contact, type, price);

            mDatabase.child(id).setValue(purchase);
            Toast.makeText(this, "Details Successfully Added", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
            Intent intent = new Intent(ProductDetails.this, BuyAndSell.class);
            startActivity(intent);
            finish();



        }else {
            Toast.makeText(this, "Enter details", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

        }
    }
}
