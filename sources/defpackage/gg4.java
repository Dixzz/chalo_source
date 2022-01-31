package defpackage;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Objects;

/* renamed from: gg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class gg4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ xf4 f1256a;

    public gg4(xf4 xf4) {
        this.f1256a = xf4;
    }

    public final void a() {
        this.f1256a.b();
        eb4 i = this.f1256a.i();
        Objects.requireNonNull((db2) this.f1256a.f3331a.n);
        if (i.t(System.currentTimeMillis())) {
            this.f1256a.i().r.a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f1256a.g().n.a("Detected application was in foreground");
                Objects.requireNonNull((db2) this.f1256a.f3331a.n);
                c(System.currentTimeMillis(), false);
            }
        }
    }

    public final void b(long j, boolean z) {
        this.f1256a.b();
        this.f1256a.w();
        if (this.f1256a.i().t(j)) {
            this.f1256a.i().r.a(true);
        }
        this.f1256a.i().u.b(j);
        if (this.f1256a.i().r.b()) {
            c(j, z);
        }
    }

    public final void c(long j, boolean z) {
        this.f1256a.b();
        if (this.f1256a.f3331a.d()) {
            this.f1256a.i().u.b(j);
            Objects.requireNonNull((db2) this.f1256a.f3331a.n);
            this.f1256a.g().n.b("Session started, time", Long.valueOf(SystemClock.elapsedRealtime()));
            Long valueOf = Long.valueOf(j / 1000);
            this.f1256a.k().J("auto", "_sid", valueOf, j);
            this.f1256a.i().r.a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.f1256a.f3331a.g.l(q64.k0) && z) {
                bundle.putLong("_aib", 1);
            }
            this.f1256a.k().D("auto", "_s", j, bundle);
            if (bz3.a() && this.f1256a.f3331a.g.l(q64.p0)) {
                String a2 = this.f1256a.i().z.a();
                if (!TextUtils.isEmpty(a2)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_ffr", a2);
                    this.f1256a.k().D("auto", "_ssr", j, bundle2);
                }
            }
        }
    }
}
