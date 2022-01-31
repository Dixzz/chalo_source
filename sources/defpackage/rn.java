package defpackage;

import android.os.Build;

/* renamed from: rn  reason: default package */
/* compiled from: TransitionUtils */
public class rn {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f3102a = true;
    public static final boolean b = true;
    public static final boolean c;

    static {
        int i = Build.VERSION.SDK_INT;
        boolean z = true;
        if (i < 28) {
            z = false;
        }
        c = z;
    }
}
