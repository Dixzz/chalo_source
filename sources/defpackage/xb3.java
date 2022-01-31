package defpackage;

import android.text.TextUtils;
import android.util.Log;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.util.Objects;

/* renamed from: xb3  reason: default package */
public class xb3 {
    public final ac3 f;

    public xb3(ac3 ac3) {
        Objects.requireNonNull(ac3, "null reference");
        this.f = ac3;
    }

    public static String n(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return obj == Boolean.TRUE ? "true" : "false";
        }
        if (obj instanceof Throwable) {
            return ((Throwable) obj).toString();
        }
        return obj.toString();
    }

    public static String q(String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String n = n(obj);
        String n2 = n(obj2);
        String n3 = n(obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(n)) {
            sb.append(str2);
            sb.append(n);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(n2)) {
            sb.append(str2);
            sb.append(n2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(n3)) {
            sb.append(str3);
            sb.append(n3);
        }
        return sb.toString();
    }

    public final sb3 A() {
        return this.f.e();
    }

    public final je3 D() {
        ac3 ac3 = this.f;
        ac3.a(ac3.i);
        return ac3.i;
    }

    public final vd3 E() {
        ac3 ac3 = this.f;
        ac3.a(ac3.j);
        return ac3.j;
    }

    public final void J(String str, Object obj) {
        j(5, str, obj, null, null);
    }

    public final void K(String str, Object obj, Object obj2) {
        j(6, str, obj, obj2, null);
    }

    public final void L(String str, Object obj) {
        j(6, str, obj, null, null);
    }

    public final void M(String str) {
        j(2, str, null, null, null);
    }

    public final void P(String str) {
        j(3, str, null, null, null);
    }

    public final void T(String str) {
        j(5, str, null, null, null);
    }

    public final void V(String str) {
        j(6, str, null, null, null);
    }

    public final void j(int i, String str, Object obj, Object obj2, Object obj3) {
        ac3 ac3 = this.f;
        vd3 vd3 = null;
        sd3 sd3 = ac3 != null ? ac3.e : null;
        if (sd3 != null) {
            V v = id3.b.f1906a;
            if (Log.isLoggable(v, i)) {
                Log.println(i, v, q(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                synchronized (sd3) {
                    Objects.requireNonNull(str, "null reference");
                    if (i < 0) {
                        i = 0;
                    }
                    if (i >= 9) {
                        i = 8;
                    }
                    char c = sd3.f.d.a() ? 'C' : 'c';
                    char charAt = "01VDIWEA?".charAt(i);
                    String str2 = zb3.f4152a;
                    String q = q(str, sd3.m0(obj), sd3.m0(obj2), sd3.m0(obj3));
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(q).length());
                    sb.append("3");
                    sb.append(charAt);
                    sb.append(c);
                    sb.append(str2);
                    sb.append(ProductDiscountsObject.KEY_DELIMITER);
                    sb.append(q);
                    String sb2 = sb.toString();
                    if (sb2.length() > 1024) {
                        sb2 = sb2.substring(0, 1024);
                    }
                    ac3 ac32 = sd3.f;
                    vd3 vd32 = ac32.j;
                    if (vd32 != null) {
                        if (vd32.X()) {
                            vd3 = ac32.j;
                        }
                    }
                    if (vd3 != null) {
                        vd3.k.a(sb2);
                    }
                }
                return;
            }
            return;
        }
        V v2 = id3.b.f1906a;
        if (Log.isLoggable(v2, i)) {
            Log.println(i, v2, q(str, obj, obj2, obj3));
        }
    }

    public final void k(String str, Object obj) {
        j(2, str, obj, null, null);
    }

    public final void o(String str, Object obj) {
        j(3, str, obj, null, null);
    }

    public final void p(String str, Object obj, Object obj2) {
        j(3, str, obj, obj2, null);
    }

    public final void r(String str, Object obj, Object obj2) {
        j(5, str, obj, obj2, null);
    }

    public final sd3 t() {
        return this.f.c();
    }

    public final jz1 w() {
        return this.f.d();
    }

    public final vy1 x() {
        return this.f.f();
    }
}
