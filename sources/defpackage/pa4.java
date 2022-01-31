package defpackage;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: pa4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class pa4 extends sc4 {
    public static final AtomicReference<String[]> c = new AtomicReference<>();
    public static final AtomicReference<String[]> d = new AtomicReference<>();
    public static final AtomicReference<String[]> e = new AtomicReference<>();

    public pa4(vb4 vb4) {
        super(vb4);
    }

    public static String u(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        Objects.requireNonNull(atomicReference, "null reference");
        gj1.b(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (ug4.p0(str, strArr[i])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    @Override // defpackage.sc4
    public final boolean p() {
        return false;
    }

    public final String q(Bundle bundle) {
        String str;
        if (bundle == null) {
            return null;
        }
        if (!y()) {
            return bundle.toString();
        }
        StringBuilder i0 = hj1.i0("Bundle[{");
        for (String str2 : bundle.keySet()) {
            if (i0.length() != 8) {
                i0.append(", ");
            }
            i0.append(w(str2));
            i0.append("=");
            Object obj = bundle.get(str2);
            if (obj instanceof Bundle) {
                str = v(new Object[]{obj});
            } else if (obj instanceof Object[]) {
                str = v((Object[]) obj);
            } else if (obj instanceof ArrayList) {
                str = v(((ArrayList) obj).toArray());
            } else {
                str = String.valueOf(obj);
            }
            i0.append(str);
        }
        i0.append("}]");
        return i0.toString();
    }

    public final String s(zzaq zzaq) {
        String str;
        if (!y()) {
            return zzaq.toString();
        }
        StringBuilder i0 = hj1.i0("origin=");
        i0.append(zzaq.h);
        i0.append(",name=");
        i0.append(t(zzaq.f));
        i0.append(",params=");
        zzap zzap = zzaq.g;
        if (zzap == null) {
            str = null;
        } else if (!y()) {
            str = zzap.toString();
        } else {
            str = q(zzap.m1());
        }
        i0.append(str);
        return i0.toString();
    }

    public final String t(String str) {
        if (str == null) {
            return null;
        }
        if (!y()) {
            return str;
        }
        return u(str, wc4.c, wc4.f3761a, c);
    }

    public final String v(Object[] objArr) {
        String str;
        if (objArr == null) {
            return "[]";
        }
        StringBuilder i0 = hj1.i0("[");
        for (Object obj : objArr) {
            if (obj instanceof Bundle) {
                str = q((Bundle) obj);
            } else {
                str = String.valueOf(obj);
            }
            if (str != null) {
                if (i0.length() != 1) {
                    i0.append(", ");
                }
                i0.append(str);
            }
        }
        i0.append("]");
        return i0.toString();
    }

    public final String w(String str) {
        if (str == null) {
            return null;
        }
        if (!y()) {
            return str;
        }
        return u(str, vc4.b, vc4.f3631a, d);
    }

    public final String x(String str) {
        if (str == null) {
            return null;
        }
        if (!y()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return u(str, yc4.b, yc4.f4031a, e);
        }
        return "experiment_id" + "(" + str + ")";
    }

    public final boolean y() {
        return this.f3331a.v() && this.f3331a.g().w(3);
    }
}
