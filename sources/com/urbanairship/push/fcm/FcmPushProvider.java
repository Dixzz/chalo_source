package com.urbanairship.push.fcm;

import android.content.Context;
import com.google.firebase.messaging.Constants;
import com.urbanairship.AirshipVersionInfo;
import com.urbanairship.push.PushProvider;

public class FcmPushProvider implements PushProvider, AirshipVersionInfo {
    @Override // com.urbanairship.AirshipVersionInfo
    public String getAirshipVersion() {
        return "14.6.0";
    }

    @Override // com.urbanairship.push.PushProvider
    public String getDeliveryType() {
        return Constants.ScionAnalytics.ORIGIN_FCM;
    }

    @Override // com.urbanairship.AirshipVersionInfo
    public String getPackageVersion() {
        return "!SDK-VERSION-STRING!:com.urbanairship.android:urbanairship-core:14.6.0";
    }

    @Override // com.urbanairship.push.PushProvider
    public int getPlatform() {
        return 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0039 A[Catch:{ Exception -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e A[Catch:{ Exception -> 0x0048 }] */
    @Override // com.urbanairship.push.PushProvider
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getRegistrationToken(android.content.Context r4) throws com.urbanairship.push.PushProvider.a {
        /*
            r3 = this;
            com.urbanairship.UAirship r4 = com.urbanairship.UAirship.l()     // Catch:{ Exception -> 0x0048 }
            com.urbanairship.AirshipConfigOptions r4 = r4.e     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = r4.j     // Catch:{ Exception -> 0x0048 }
            boolean r0 = defpackage.hd3.G1(r4)     // Catch:{ Exception -> 0x0048 }
            r1 = 0
            if (r0 == 0) goto L_0x0010
            goto L_0x0022
        L_0x0010:
            com.google.firebase.FirebaseApp r0 = com.google.firebase.FirebaseApp.getInstance()     // Catch:{ Exception -> 0x0048 }
            com.google.firebase.FirebaseOptions r0 = r0.getOptions()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r0 = r0.getGcmSenderId()     // Catch:{ Exception -> 0x0048 }
            boolean r0 = r4.equals(r0)     // Catch:{ Exception -> 0x0048 }
            if (r0 == 0) goto L_0x0024
        L_0x0022:
            r4 = r1
            goto L_0x002c
        L_0x0024:
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = "The airship config options specify an fcmSenderId that overrides the sender ID from the default Firebase project. This configuration is no longer recommended by Firebase and may not be supported by future versions of the Airship Android SDK. Firebase currently recommends using a single Firebase Project/Firebase App for both FCM and Crashlytics."
            defpackage.yj5.c(r1, r0)     // Catch:{ Exception -> 0x0048 }
        L_0x002c:
            if (r4 == 0) goto L_0x0039
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance()     // Catch:{ Exception -> 0x0048 }
            java.lang.String r1 = "FCM"
            java.lang.String r4 = r0.getToken(r4, r1)     // Catch:{ Exception -> 0x0048 }
            return r4
        L_0x0039:
            com.google.firebase.messaging.FirebaseMessaging r4 = com.google.firebase.messaging.FirebaseMessaging.getInstance()     // Catch:{ Exception -> 0x0048 }
            yi4 r4 = r4.getToken()     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r4 = defpackage.hd3.u(r4)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0048 }
            return r4
        L_0x0048:
            r4 = move-exception
            com.urbanairship.push.PushProvider$a r0 = new com.urbanairship.push.PushProvider$a
            java.lang.String r1 = "FCM error "
            java.lang.StringBuilder r1 = defpackage.hj1.i0(r1)
            java.lang.String r2 = r4.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r0.<init>(r1, r2, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.push.fcm.FcmPushProvider.getRegistrationToken(android.content.Context):java.lang.String");
    }

    @Override // com.urbanairship.push.PushProvider
    public boolean isAvailable(Context context) {
        try {
            if ((pq5.a() ? hd3.L1(context) : -1) == 0) {
                return true;
            }
            yj5.f("Google Play services is currently unavailable.", new Object[0]);
            return false;
        } catch (Exception e) {
            yj5.e(e, "Unable to register with FCM.", new Object[0]);
            return false;
        }
    }

    @Override // com.urbanairship.push.PushProvider
    public boolean isSupported(Context context) {
        return pq5.b(context);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("FCM Push Provider ");
        i0.append(getAirshipVersion());
        return i0.toString();
    }
}
