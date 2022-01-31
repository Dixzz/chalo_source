package defpackage;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.razorpay.AnalyticsConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: fh5  reason: default package */
/* compiled from: CallRejector.kt */
public final class fh5 implements eh5 {

    /* renamed from: a  reason: collision with root package name */
    public final TelephonyManager f1124a;

    public fh5(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        Object systemService = context.getSystemService("phone");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        this.f1124a = (TelephonyManager) systemService;
    }

    @Override // defpackage.eh5
    public boolean a() {
        try {
            Object b = b(this.f1124a, "getITelephony");
            if (b != null) {
                b(b, "endCall");
            }
            return true;
        } catch (Exception unused) {
            try {
                Object b2 = b(this.f1124a, "getITelephonyMSim");
                if (b2 != null) {
                    if (n86.a(c(b2, "endCall", 0), Boolean.FALSE)) {
                        c(b2, "endCall", 1);
                    }
                    return true;
                }
            } catch (Exception unused2) {
            }
            return false;
        }
    }

    public final Object b(Object obj, String str) {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, new Object[0]);
    }

    public final Object c(Object obj, String str, Object... objArr) {
        Class<?> cls = obj.getClass();
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj2 : objArr) {
            arrayList.add(obj2.getClass());
        }
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class[] clsArr = (Class[]) array;
        Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(obj, objArr);
    }
}
