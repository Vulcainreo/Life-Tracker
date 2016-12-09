package com.example.vulcainreo.lifetracker;

import org.json.JSONObject;

/**
 * Created by vulcainreo on 29/11/16.
 */

public class MacAddress {
    int id;
    String address;
    String name;
    int rssi;

    public MacAddress() {

    }

    public MacAddress(String address, String name, int rssi) {

        this.address = address;
        this.name = name;
        this.rssi = rssi;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) { this.address = address; }

    public int getRssi() { return rssi; }

    public void setRssi(int rssi) { this.rssi = rssi; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", this.id);
            jsonObject.put("address", this.address);
            jsonObject.put("name", this.name);
            jsonObject.put("rssi", this.rssi);
        } catch (Exception e) {

        }

        return jsonObject.toString();
    }
}
