package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import server.zophop.Constants;

/* renamed from: fd3  reason: default package */
public final class fd3 extends yb3 {
    public boolean h;
    public boolean i;
    public final AlarmManager j = ((AlarmManager) this.f.f146a.getSystemService("alarm"));
    public Integer k;

    public fd3(ac3 ac3) {
        super(ac3);
    }

    @Override // defpackage.yb3
    public final void a0() {
        try {
            i0();
            if (ad3.b() > 0) {
                Context context = this.f.f146a;
                ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo != null && receiverInfo.enabled) {
                    M("Receiver registered for local dispatch.");
                    this.h = true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void i0() {
        this.i = false;
        this.j.cancel(m0());
        if (Build.VERSION.SDK_INT >= 24) {
            int j0 = j0();
            k("Cancelling job. JobID", Integer.valueOf(j0));
            ((JobScheduler) this.f.f146a.getSystemService("jobscheduler")).cancel(j0);
        }
    }

    public final int j0() {
        if (this.k == null) {
            String valueOf = String.valueOf(this.f.f146a.getPackageName());
            this.k = Integer.valueOf((valueOf.length() != 0 ? Constants.PRODUCTION_ANALYTICS.concat(valueOf) : new String(Constants.PRODUCTION_ANALYTICS)).hashCode());
        }
        return this.k.intValue();
    }

    public final PendingIntent m0() {
        Context context = this.f.f146a;
        return PendingIntent.getBroadcast(context, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }
}
