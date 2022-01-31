package com.rabbitmq.client;

import app.zophop.models.mTicketing.ProductDiscountsObject;

public class Address {
    private final String _host;
    private final int _port;

    public Address(String str, int i) {
        this._host = str;
        this._port = i;
    }

    public static Address parseAddress(String str) {
        int indexOf = str.indexOf(58);
        return indexOf == -1 ? new Address(str) : new Address(str.substring(0, indexOf), Integer.parseInt(str.substring(indexOf + 1)));
    }

    public static Address[] parseAddresses(String str) {
        String[] split = str.split(" *, *");
        Address[] addressArr = new Address[split.length];
        for (int i = 0; i < split.length; i++) {
            addressArr[i] = parseAddress(split[i]);
        }
        return addressArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Address address = (Address) obj;
        if (!this._host.equals(address._host) || this._port != address._port) {
            return false;
        }
        return true;
    }

    public String getHost() {
        return this._host;
    }

    public int getPort() {
        return this._port;
    }

    public int hashCode() {
        return (this._host.hashCode() * 31) + this._port;
    }

    public String toString() {
        if (this._port == -1) {
            return this._host;
        }
        return this._host + ProductDiscountsObject.KEY_DELIMITER + this._port;
    }

    public Address(String str) {
        this._host = str;
        this._port = -1;
    }
}
