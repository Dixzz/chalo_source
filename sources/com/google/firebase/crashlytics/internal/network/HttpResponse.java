package com.google.firebase.crashlytics.internal.network;

import java.io.IOException;

public class HttpResponse {
    private String body;
    private int code;
    private ci6 headers;

    public HttpResponse(int i, String str, ci6 ci6) {
        this.code = i;
        this.body = str;
        this.headers = ci6;
    }

    public static HttpResponse create(ni6 ni6) throws IOException {
        String str;
        oi6 oi6 = ni6.m;
        if (oi6 == null) {
            str = null;
        } else {
            str = oi6.string();
        }
        return new HttpResponse(ni6.j, str, ni6.l);
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }

    public String header(String str) {
        return this.headers.b(str);
    }
}
