package defpackage;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.Objects;

/* renamed from: eg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class eg4 {

    /* renamed from: a  reason: collision with root package name */
    public long f969a;
    public long b;
    public final j64 c;
    public final /* synthetic */ xf4 d;

    public eg4(xf4 xf4) {
        this.d = xf4;
        this.c = new dg4(this, xf4.f3331a);
        Objects.requireNonNull((db2) xf4.f3331a.n);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f969a = elapsedRealtime;
        this.b = elapsedRealtime;
    }

    public final boolean a(boolean z, boolean z2, long j) {
        this.d.b();
        this.d.s();
        if (!sz3.a() || !this.d.f3331a.g.l(q64.q0) || this.d.f3331a.d()) {
            ib4 ib4 = this.d.i().u;
            Objects.requireNonNull((db2) this.d.f3331a.n);
            ib4.b(System.currentTimeMillis());
        }
        long j2 = j - this.f969a;
        if (z || j2 >= 1000) {
            if (this.d.f3331a.g.l(q64.T) && !z2) {
                if (!((wz3) tz3.g.zza()).zza() || !this.d.f3331a.g.l(q64.V)) {
                    j2 = b();
                } else {
                    j2 = j - this.b;
                    this.b = j;
                }
            }
            this.d.g().n.b("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            ie4.z(this.d.o().v(!this.d.f3331a.g.y().booleanValue()), bundle, true);
            if (this.d.f3331a.g.l(q64.T) && !this.d.f3331a.g.l(q64.U) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.d.f3331a.g.l(q64.U) || !z2) {
                this.d.k().G("auto", "_e", bundle);
            }
            this.f969a = j;
            this.c.c();
            this.c.b(3600000);
            return true;
        }
        this.d.g().n.b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    public final long b() {
        Objects.requireNonNull((db2) this.d.f3331a.n);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - this.b;
        this.b = elapsedRealtime;
        return j;
    }
}
