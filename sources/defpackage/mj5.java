package defpackage;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.truecaller.multisim.SimInfo;
import java.util.Collections;
import java.util.List;

/* renamed from: mj5  reason: default package */
/* compiled from: SingleSimManager */
public class mj5 extends ri5 {
    public final TelephonyManager c;

    public mj5(Context context, TelephonyManager telephonyManager) {
        super(context);
        this.c = telephonyManager;
    }

    @Override // defpackage.qi5
    public List<SimInfo> a() {
        String str;
        String str2;
        String str3 = null;
        try {
            str = this.c.getDeviceId();
        } catch (SecurityException unused) {
            str = null;
        }
        try {
            str2 = this.c.getSimSerialNumber();
        } catch (SecurityException unused2) {
            str2 = null;
        }
        try {
            str3 = this.c.getSubscriberId();
        } catch (SecurityException unused3) {
        }
        return Collections.singletonList(new SimInfo(0, "-1", this.c.getLine1Number(), this.c.getSimOperatorName(), this.c.getSimOperator(), this.c.getSimCountryIso(), str, str2, str3, this.c.isNetworkRoaming()));
    }
}
