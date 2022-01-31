package defpackage;

import android.annotation.SuppressLint;

@Deprecated
/* renamed from: rd3  reason: default package */
public final class rd3 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile bd3 f3068a = new bd3();

    public static boolean a(int i) {
        return 2 <= i;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void b(String str) {
        sd3 sd3 = sd3.h;
        if (sd3 != null) {
            sd3.M(str);
        } else if (a(0)) {
            V v = id3.b.f1906a;
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void c(String str) {
        sd3 sd3 = sd3.h;
        if (sd3 != null) {
            sd3.T(str);
        } else if (a(2)) {
            V v = id3.b.f1906a;
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        sd3 sd3 = sd3.h;
        if (sd3 != null) {
            sd3.L(str, obj);
        } else if (a(3)) {
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                str.length();
                valueOf.length();
            }
            V v = id3.b.f1906a;
        }
    }
}
