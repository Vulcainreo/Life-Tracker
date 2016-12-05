package com.example.vulcainreo.lifetracker;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

public class GetArroundMacService extends IntentService {

    public GetArroundMacService() {
        super("GetArroundMacService");
    }

    protected void onHandleIntent(Intent intent) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "service started", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
