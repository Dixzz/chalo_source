package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* renamed from: cr4  reason: default package */
public final class cr4 {
    public static final nv4 e = new nv4("AppUpdateService");
    public static final Intent f = new Intent("com.google.android.play.core.install.BIND_UPDATE_SERVICE").setPackage("com.android.vending");

    /* renamed from: a  reason: collision with root package name */
    public xv4<tw4> f747a;
    public final String b;
    public final Context c;
    public final er4 d;

    public cr4(Context context, er4 er4) {
        this.b = context.getPackageName();
        this.c = context;
        this.d = er4;
        if (zv4.a(context)) {
            Context applicationContext = context.getApplicationContext();
            this.f747a = new xv4<>(applicationContext != null ? applicationContext : context, e, "AppUpdateService", f, wq4.f3827a);
        }
    }

    public static Bundle a(cr4 cr4, String str) {
        Integer num;
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        bundle2.putAll(av4.a("app_update"));
        bundle2.putInt("playcore.version.code", 10901);
        bundle.putAll(bundle2);
        bundle.putString("package.name", str);
        try {
            num = Integer.valueOf(cr4.c.getPackageManager().getPackageInfo(cr4.c.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            e.b(6, "The current version of the app could not be retrieved", new Object[0]);
            num = null;
        }
        if (num != null) {
            bundle.putInt("app.version.code", num.intValue());
        }
        return bundle;
    }

    public static <T> ey4<T> b() {
        e.b(6, "onError(%d)", new Object[]{-9});
        ev4 ev4 = new ev4(-9);
        ey4<T> ey4 = new ey4<>();
        ey4.c(ev4);
        return ey4;
    }
}
