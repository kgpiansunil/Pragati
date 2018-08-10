package com.example.sunil.pragati.market;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sunil.pragati.R;

import java.util.List;

/**
 * Created by SUNIL on 3/22/2018.
 */

public class PurchaseList extends ArrayAdapter<Purchase> {

    private Activity context;
    private List<Purchase> purchaseList;


    public PurchaseList( Activity context, List<Purchase> purchaseList) {

        super(context, R.layout.users_single_layout, purchaseList);
        this.context = context;
        this.purchaseList = purchaseList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= context.getLayoutInflater();
        @SuppressLint("ViewHolder") View listViewItem = inflater.inflate(R.layout.users_single_layout, null, true);

        TextView mName = (TextView) listViewItem.findViewById(R.id.userName);
        TextView mCrop = (TextView) listViewItem.findViewById(R.id.userCrop);
        TextView mContact = (TextView) listViewItem.findViewById(R.id.userContact);
        TextView mPrice = (TextView) listViewItem.findViewById(R.id.userPrice);


        Purchase purchase = purchaseList.get(position);
        mName.setText(purchase.farmersName);
        mCrop.setText(purchase.farmerProduct);
        mContact.setText(purchase.farmersContact);
        mPrice.setText(purchase.farmerPrice + " Rs/Kg");

        return listViewItem;

    }
}
