package com.example.vulcainreo.lifetracker;

/**
 * Created by vulcainreo on 29/11/16.
 */

public class MacAddress {
    int id;
    String address;

    public MacAddress() {

    }

    public MacAddress(String address) {

        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getMacAddress() {
        return this.address;
    }

    public void setMacAddress(String macAddress) {

        this.address = macAddress;
    }
}
