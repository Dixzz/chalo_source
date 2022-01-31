package defpackage;

import android.os.Build;
import android.view.ViewGroup;

/* renamed from: un  reason: default package */
/* compiled from: ViewGroupUtils */
public class un {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f3526a = true;

    public static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (f3526a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f3526a = false;
            }
        }
    }
}
