package com.urbanairship.push;

import android.content.Context;

public interface PushProvider {
    String getDeliveryType();

    int getPlatform();

    String getRegistrationToken(Context context) throws a;

    boolean isAvailable(Context context);

    boolean isSupported(Context context);

    public static class a extends Exception {
        public final boolean f;

        public a(String str, boolean z, Throwable th) {
            super(str, th);
            this.f = z;
        }

        public a(String str, boolean z) {
            super(str);
            this.f = z;
        }
    }
}
