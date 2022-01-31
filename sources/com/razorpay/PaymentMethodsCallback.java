package com.razorpay;

public interface PaymentMethodsCallback {
    void onError(String str);

    void onPaymentMethodsReceived(String str);
}
