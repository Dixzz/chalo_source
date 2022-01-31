package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.CallLog;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import com.truecaller.multisim.SimInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: jj5  reason: default package */
/* compiled from: MultiSimManagerSamsung */
public class jj5 extends ri5 {
    public static final /* synthetic */ int e = 0;
    public final TelephonyManager c;
    public final TelephonyManager d;

    @SuppressLint({"PrivateApi"})
    public jj5(Context context) throws Exception {
        super(context);
        Class<?> cls = Class.forName("android.telephony.MultiSimTelephonyManager");
        Class<?> cls2 = Integer.TYPE;
        Method method = cls.getMethod("getDefault", cls2);
        this.c = (TelephonyManager) method.invoke(null, 0);
        this.d = (TelephonyManager) method.invoke(null, 1);
        cls.getMethod("getDefault", new Class[0]);
        Class.forName("com.android.internal.telephony.MultiSimManager").getMethod("isMultiSimSlot", new Class[0]);
        Method method2 = Class.forName("android.telephony.MultiSimSmsManager").getMethod("getDefault", cls2);
        SmsManager smsManager = (SmsManager) method2.invoke(null, 0);
        SmsManager smsManager2 = (SmsManager) method2.invoke(null, 1);
        String str = (String) CallLog.Calls.class.getField("SIM_ID").get(null);
    }

    @Override // defpackage.qi5
    public List<SimInfo> a() {
        ArrayList arrayList = new ArrayList();
        SimInfo b = b(0);
        if (b != null) {
            arrayList.add(b);
        }
        SimInfo b2 = b(1);
        if (b2 != null) {
            arrayList.add(b2);
        }
        return arrayList;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public SimInfo b(int i) {
        TelephonyManager telephonyManager = 1 == i ? this.d : this.c;
        String subscriberId = telephonyManager.getSubscriberId();
        if (subscriberId == null) {
            return null;
        }
        return new SimInfo(i, subscriberId, telephonyManager.getLine1Number(), telephonyManager.getSimOperatorName(), telephonyManager.getSimOperator(), telephonyManager.getSimCountryIso(), telephonyManager.getDeviceId(), telephonyManager.getSimSerialNumber(), null, telephonyManager.isNetworkRoaming());
    }
}
