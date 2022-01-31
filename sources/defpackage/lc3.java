package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* renamed from: lc3  reason: default package */
public final class lc3 extends yb3 {
    public final oe3 h = new oe3();

    public lc3(ac3 ac3) {
        super(ac3);
    }

    @Override // defpackage.yb3
    public final void a0() {
        jz1 w = w();
        if (w.d == null) {
            synchronized (w) {
                if (w.d == null) {
                    oe3 oe3 = new oe3();
                    PackageManager packageManager = w.f1998a.getPackageManager();
                    String packageName = w.f1998a.getPackageName();
                    oe3.c = packageName;
                    oe3.d = packageManager.getInstallerPackageName(packageName);
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(w.f1998a.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(packageName);
                        if (valueOf.length() != 0) {
                            "Error retrieving package info: appName set to ".concat(valueOf);
                        } else {
                            new String("Error retrieving package info: appName set to ");
                        }
                    }
                    oe3.f2681a = packageName;
                    oe3.b = str;
                    w.d = oe3;
                }
            }
        }
        w.d.c(this.h);
        je3 D = D();
        D.g0();
        String str2 = D.i;
        if (str2 != null) {
            this.h.f2681a = str2;
        }
        D.g0();
        String str3 = D.h;
        if (str3 != null) {
            this.h.b = str3;
        }
    }
}
