package defpackage;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.provider.Telephony;
import android.telephony.TelephonyManager;
import java.util.ArrayList;

/* renamed from: ti5  reason: default package */
/* compiled from: MultiSimManagerLg */
public class ti5 extends wi5 {
    public static final /* synthetic */ int o = 0;
    public final Object n;

    @SuppressLint({"PrivateApi"})
    public ti5(Context context, TelephonyManager telephonyManager) throws Exception {
        super(context, telephonyManager);
        String str = (String) Telephony.Sms.class.getField("SUB_ID").get(null);
        String str2 = (String) Telephony.Mms.class.getField("SUB_ID").get(null);
        Object invoke = Class.forName("android.telephony.MSimSmsManager").getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
        this.n = invoke;
        Class<?> cls = invoke.getClass();
        Class<?> cls2 = Long.TYPE;
        cls.getMethod("sendTextMessage", String.class, String.class, String.class, PendingIntent.class, PendingIntent.class, cls2);
        invoke.getClass().getMethod("sendMultipartTextMessage", String.class, String.class, ArrayList.class, ArrayList.class, ArrayList.class, cls2);
    }
}
