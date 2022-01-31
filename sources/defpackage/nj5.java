package defpackage;

import android.content.Context;

/* renamed from: nj5  reason: default package */
/* compiled from: PermissionHelper */
public class nj5 {

    /* renamed from: a  reason: collision with root package name */
    public Context f2566a;

    public nj5(Context context) {
        this.f2566a = context;
    }

    public boolean a(String... strArr) {
        try {
            for (String str : strArr) {
                if (q5.a(this.f2566a, str) == -1) {
                    return false;
                }
            }
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
