package com.example.vulcainreo.lifetracker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewMacActivity extends Activity {

    private ListView list;
    MacAdapter adapter;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mac);

        db = new DatabaseHandler(this);
        ArrayList<MacAddress> listMac = db.getAllMac();

        ListView listAddress = (ListView)findViewById(R.id.listAllAddressMac);
        MacAdapter adapter = new MacAdapter(this, listMac);
        listAddress.setAdapter(adapter);
    }
}
