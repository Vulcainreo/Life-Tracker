package com.example.vulcainreo.lifetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vulcainreo on 30/11/16.
 */

public class MacAdapter extends ArrayAdapter<MacAddress> {

    public MacAdapter(Context context, ArrayList<MacAddress> macAddresses) {
        super(context, 0, macAddresses);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MacAddress mac = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mac_item, parent, false);
        }
        // Lookup view for data population
        TextView tvAdresse = (TextView) convertView.findViewById(R.id.address);
        //TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvAdresse.setText(mac.getAddress() +"-"+ mac.getName() +"-"+ mac.getRssi());
        //tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
