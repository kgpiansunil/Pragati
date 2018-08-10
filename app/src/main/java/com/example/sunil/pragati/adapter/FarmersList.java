package com.example.sunil.pragati.adapter;

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
import com.example.sunil.pragati.model.Farmers;

import java.util.List;

/**
 * Created by SUNIL on 3/22/2018.
 */

public class FarmersList extends ArrayAdapter<Farmers> {

    private Activity context;
    private List<Farmers> farmersList;


    public FarmersList( Activity context, List<Farmers> farmersList) {

        super(context, R.layout.farmers_list_layout, farmersList);
        this.context = context;
        this.farmersList = farmersList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= context.getLayoutInflater();
        @SuppressLint("ViewHolder") View listViewItem = inflater.inflate(R.layout.farmers_list_layout, null, true);

        TextView mName = (TextView) listViewItem.findViewById(R.id.fName);
        TextView mAdd = (TextView) listViewItem.findViewById(R.id.fAdd);
        TextView mContact = (TextView) listViewItem.findViewById(R.id.fContact);
        TextView mType = (TextView) listViewItem.findViewById(R.id.fType);


        Farmers farmers = farmersList.get(position);
        mName.setText(farmers.farmersName);
        mAdd.setText(farmers.farmerAdd);
        mContact.setText(farmers.farmersContact);
        mType.setText(farmers.farmerType);

        return listViewItem;

    }
}
