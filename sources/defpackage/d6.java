package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import defpackage.y5;

@SuppressLint({"NewApi"})
/* renamed from: d6  reason: default package */
/* compiled from: TypefaceCompat */
public class d6 {

    /* renamed from: a  reason: collision with root package name */
    public static final k6 f792a;
    public static final s2<String, Typeface> b = new s2<>(16);

    /* renamed from: d6$a */
    /* compiled from: TypefaceCompat */
    public static class a extends l7 {

        /* renamed from: a  reason: collision with root package name */
        public y5.c f793a;

        public a(y5.c cVar) {
            this.f793a = cVar;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f792a = new i6();
        } else if (i >= 28) {
            f792a = new h6();
        } else if (i >= 26) {
            f792a = new g6();
        } else {
            if (i >= 24) {
                if (f6.d != null) {
                    f792a = new f6();
                }
            }
            f792a = new e6();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r0.equals(r4) == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(android.content.Context r5, defpackage.t5 r6, android.content.res.Resources r7, int r8, int r9, defpackage.y5.c r10, android.os.Handler r11, boolean r12) {
        /*
        // Method dump skipped, instructions count: 362
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d6.a(android.content.Context, t5, android.content.res.Resources, int, int, y5$c, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Typeface b(Context context, Resources resources, int i, String str, int i2) {
        Typeface d = f792a.d(context, resources, i, str, i2);
        if (d != null) {
            b.put(c(resources, i, i2), d);
        }
        return d;
    }

    public static String c(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
