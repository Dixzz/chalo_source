package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: xt4  reason: default package */
public final class xt4 {
    public static final nv4 c = new nv4("PackageStateCache");

    /* renamed from: a  reason: collision with root package name */
    public final Context f3965a;
    public int b = -1;

    public xt4(Context context) {
        this.f3965a = context;
    }

    public final synchronized int a() {
        if (this.b == -1) {
            try {
                this.b = this.f3965a.getPackageManager().getPackageInfo(this.f3965a.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                c.b(6, "The current version of the app could not be retrieved", new Object[0]);
            }
        }
        return this.b;
    }
}
