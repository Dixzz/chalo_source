package defpackage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* renamed from: ig4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class ig4 extends jg4 {
    public final AlarmManager d = ((AlarmManager) this.f3331a.f3627a.getSystemService("alarm"));
    public final j64 e;
    public Integer f;

    public ig4(lg4 lg4) {
        super(lg4);
        this.e = new hg4(this, lg4.j, lg4);
    }

    @Override // defpackage.jg4
    public final boolean n() {
        this.d.cancel(t());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        ((JobScheduler) this.f3331a.f3627a.getSystemService("jobscheduler")).cancel(s());
        return false;
    }

    public final void q() {
        k();
        g().n.a("Unscheduling upload");
        this.d.cancel(t());
        this.e.c();
        if (Build.VERSION.SDK_INT >= 24) {
            ((JobScheduler) this.f3331a.f3627a.getSystemService("jobscheduler")).cancel(s());
        }
    }

    public final int s() {
        if (this.f == null) {
            String valueOf = String.valueOf(this.f3331a.f3627a.getPackageName());
            this.f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f.intValue();
    }

    public final PendingIntent t() {
        Context context = this.f3331a.f3627a;
        return PendingIntent.getBroadcast(context, 0, new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }
}
