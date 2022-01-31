package com.razorpay;

public interface FetchPreferencesCallback {
    void onError(String str);

    void onResponse(String str);
}
