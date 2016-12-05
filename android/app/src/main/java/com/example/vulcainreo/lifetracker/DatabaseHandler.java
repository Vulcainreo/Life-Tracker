package com.example.vulcainreo.lifetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by vulcainreo on 29/11/16.
 */

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "macAddressManager";

    // Contacts table name
    private static final String TABLE_MAC = "mac";

    // Contacts Table Columns names
    private static final String KEY_ID = "_id";
    private static final String KEY_MAC = "address";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MAC_TABLE = "CREATE TABLE " + TABLE_MAC + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MAC + ")";
        db.execSQL(CREATE_MAC_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAC);

        // Create tables again
        onCreate(db);
    }

    public void addMac(MacAddress mac){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MAC, mac.getMacAddress());

        db.insert(TABLE_MAC, null, values);
        db.close();
    }
    public ArrayList<MacAddress> getAllMac(){
        ArrayList<MacAddress> macList = new ArrayList<MacAddress>();

        String selectQuery = "SELECT  * FROM " + TABLE_MAC;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                MacAddress mac = new MacAddress();
                mac.setId(Integer.parseInt(cursor.getString(0)));
                mac.setMacAddress(cursor.getString(1));
                macList.add(mac);
            } while (cursor.moveToNext());
        }
        return macList;
    }
}
