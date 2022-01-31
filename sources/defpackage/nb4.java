package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.List;

/* renamed from: nb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class nb4 {

    /* renamed from: a  reason: collision with root package name */
    public final vb4 f2532a;

    public nb4(vb4 vb4) {
        this.f2532a = vb4;
    }

    public final void a(String str) {
        if (str == null || str.isEmpty()) {
            this.f2532a.g().j.a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f2532a.f().b();
        if (!b()) {
            this.f2532a.g().l.a("Install Referrer Reporter is not available");
            return;
        }
        mb4 mb4 = new mb4(this, str);
        this.f2532a.f().b();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f2532a.f3627a.getPackageManager();
        if (packageManager == null) {
            this.f2532a.g().j.a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f2532a.g().l.a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !b()) {
                this.f2532a.g().i.a("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.f2532a.g().n.b("Install Referrer Service is", za2.b().a(this.f2532a.f3627a, new Intent(intent), mb4, 1) ? "available" : "not available");
            } catch (Exception e) {
                this.f2532a.g().f.b("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }

    public final boolean b() {
        try {
            nb2 a2 = ob2.a(this.f2532a.f3627a);
            if (a2 == null) {
                this.f2532a.g().n.a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (a2.f2531a.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.f2532a.g().n.b("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
