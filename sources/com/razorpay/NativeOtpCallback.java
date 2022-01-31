package com.razorpay;

public interface NativeOtpCallback {
    void onError(int i, String str);

    void onResponse(String str);
}
