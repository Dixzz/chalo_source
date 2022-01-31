package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telecom.PhoneAccount;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

/* renamed from: zi5  reason: default package */
/* compiled from: MultiSimManagerMarshmallow */
public class zi5 extends xi5 {
    public static final /* synthetic */ int h = 0;

    public zi5(Context context, SubscriptionManager subscriptionManager, TelephonyManager telephonyManager, TelecomManager telecomManager, CarrierConfigManager carrierConfigManager) throws Exception {
        super(context, subscriptionManager, telephonyManager, telecomManager);
        TelephonyManager.class.getMethod("getSubIdForPhoneAccount", PhoneAccount.class);
    }

    @Override // defpackage.xi5
    @SuppressLint({"HardwareIds"})
    public String b(int i) {
        try {
            return this.d.getDeviceId(i);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
