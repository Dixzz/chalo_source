package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.razorpay.AnalyticsConstants;
import java.util.Locale;

/* renamed from: je3  reason: default package */
public final class je3 extends yb3 {
    public String h;
    public String i;
    public boolean j;
    public int k;
    public boolean l;
    public boolean m;

    public je3(ac3 ac3) {
        super(ac3);
    }

    @Override // defpackage.yb3
    public final void a0() {
        ApplicationInfo applicationInfo;
        int i2;
        md3 md3;
        int i3;
        Context context = this.f.f146a;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            J("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            T("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null && (i2 = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) > 0 && (md3 = (md3) new kd3(this.f).Z(i2)) != null) {
            M("Loading global XML config values");
            String str = md3.f2358a;
            boolean z = false;
            if (str != null) {
                this.i = str;
                o("XML config - app name", str);
            }
            String str2 = md3.b;
            if (str2 != null) {
                this.h = str2;
                o("XML config - app version", str2);
            }
            String str3 = md3.c;
            if (str3 != null) {
                String lowerCase = str3.toLowerCase(Locale.US);
                if ("verbose".equals(lowerCase)) {
                    i3 = 0;
                } else if ("info".equals(lowerCase)) {
                    i3 = 1;
                } else if (AnalyticsConstants.WARNING.equals(lowerCase)) {
                    i3 = 2;
                } else {
                    i3 = "error".equals(lowerCase) ? 3 : -1;
                }
                if (i3 >= 0) {
                    k("XML config - log level", Integer.valueOf(i3));
                }
            }
            int i4 = md3.d;
            if (i4 >= 0) {
                this.k = i4;
                this.j = true;
                o("XML config - dispatch period (sec)", Integer.valueOf(i4));
            }
            int i5 = md3.e;
            if (i5 != -1) {
                if (i5 == 1) {
                    z = true;
                }
                this.m = z;
                this.l = true;
                o("XML config - dry run", Boolean.valueOf(z));
            }
        }
    }
}
