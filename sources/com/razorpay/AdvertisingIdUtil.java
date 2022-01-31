package com.razorpay;

import android.content.Context;

public class AdvertisingIdUtil {

    public interface AdvertisingIdCallback {
        void onResult(String str);
    }

    public static void getId(Context context, AdvertisingIdCallback advertisingIdCallback) {
        new a_$P$(context, advertisingIdCallback).execute(new Void[0]);
    }
}
