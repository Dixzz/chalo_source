package defpackage;

import android.content.Context;

/* renamed from: xd1  reason: default package */
/* compiled from: AppInfoProvider */
public class xd1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3915a;
    public final rf1 b;
    public boolean c;

    public xd1(Context context) {
        this.f3915a = context;
        rf1 rf1 = new rf1(context, "appinfo");
        this.b = rf1;
        int i = 0;
        int i2 = rf1.b.getInt("app:version", 0);
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i2 == 0 || i2 != i) {
            this.c = true;
            rf1 rf12 = this.b;
            rf12.f3075a.putInt("app:version", i);
            rf12.f3075a.commit();
        }
    }
}
