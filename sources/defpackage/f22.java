package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: f22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class f22 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1063a;
    @GuardedBy("this")
    public int b;
    @GuardedBy("this")
    public int c = 0;

    public f22(Context context) {
        this.f1063a = context;
    }

    public final synchronized int a() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.f1063a.getPackageManager();
        if (ob2.a(this.f1063a).f2531a.getPackageManager().checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            return 0;
        }
        if (!gj1.N()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.c = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            if (gj1.N()) {
                this.c = 2;
            } else {
                this.c = 1;
            }
            return this.c;
        }
        this.c = 2;
        return 2;
    }
}
