package com.example.vulcainreo.lifetracker;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> mDeviceList = new ArrayList<String>();
    private BluetoothAdapter mBluetoothAdapter;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String address = device.getAddress();
                String name = intent.getStringExtra(device.EXTRA_NAME);
                int rssi = intent.getShortExtra(device.EXTRA_RSSI, Short.MIN_VALUE);

                mDeviceList.add(address+"\n"+name+" "+String.valueOf(rssi));
                // ajout en base
                db.addMac(new MacAddress(address, name, rssi));
                // mise à jour de la liste sur la page principale
                listView.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, mDeviceList));
            }
        }
    };

    public void viewAllMac(View view) {
        Intent intent = new Intent(this, ViewMacActivity.class);
        startActivity(intent);
    }

    public void scanMac(View view) {
        db = new DatabaseHandler(this);

        listView = (ListView) findViewById(R.id.listView);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mBluetoothAdapter.startDiscovery();

        Toast.makeText(this, "Scan started", Toast.LENGTH_SHORT).show();

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter);
    }

    public void pushToServer(View view) {

    }
}