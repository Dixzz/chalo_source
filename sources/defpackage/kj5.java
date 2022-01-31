package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telecom.TelecomManager;
import com.truecaller.multisim.SimInfo;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* renamed from: kj5  reason: default package */
/* compiled from: MultiSimManagerSamsungLollipop */
public class kj5 extends ri5 {
    public static final /* synthetic */ int m = 0;
    public final Method c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Method g;
    public final Method h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Field l = Class.forName("android.telephony.SubInfoRecord").getField("subId");

    @SuppressLint({"PrivateApi"})
    public kj5(Context context, TelecomManager telecomManager) throws Exception {
        super(context);
        Class<?> cls = Class.forName("com.samsung.android.telephony.MultiSimManager");
        cls.getMethod("getEnabledSimCount", Context.class);
        cls.getMethod("getActiveSubInfoCount", new Class[0]);
        Class<?> cls2 = Integer.TYPE;
        this.c = cls.getMethod("getSimOperatorName", cls2);
        this.d = cls.getMethod("getLine1Number", cls2);
        this.e = cls.getMethod("getSubId", cls2);
        this.f = cls.getMethod("getSimOperator", cls2);
        this.g = cls.getMethod("getSimCountryIso", cls2);
        this.h = cls.getMethod("getImei", cls2);
        this.i = cls.getMethod("getSimSerialNumber", cls2);
        this.j = cls.getMethod("isNetworkRoaming", cls2);
        cls.getMethod("getNetworkCountryIso", cls2);
        cls.getMethod("getDefaultSubId", cls2);
        cls.getMethod("setDefaultSubId", cls2, Long.TYPE);
        this.k = cls.getMethod("getActiveSubInfoList", new Class[0]);
        String str = (String) TelecomManager.class.getField("EXTRA_PHONE_ACCOUNT_HANDLE").get(null);
        TelecomManager.class.getMethod("getCallCapablePhoneAccounts", new Class[0]);
        Class.forName("android.telecom.PhoneAccountHandle").getMethod("getId", new Class[0]);
    }

    @Override // defpackage.qi5
    public List<SimInfo> a() {
        ArrayList arrayList = new ArrayList();
        try {
            List<Object> list = (List) this.k.invoke(null, new Object[0]);
            if (list != null) {
                for (Object obj : list) {
                    SimInfo b = b(String.valueOf(this.l.getLong(obj)));
                    if (b != null) {
                        arrayList.add(b);
                    }
                }
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.truecaller.multisim.SimInfo b(java.lang.String r17) {
        /*
        // Method dump skipped, instructions count: 239
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kj5.b(java.lang.String):com.truecaller.multisim.SimInfo");
    }
}
