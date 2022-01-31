package com.razorpay;

public interface SubscriptionAmountCallback {
    void onError(String str);

    void onSubscriptionAmountReceived(long j);
}
