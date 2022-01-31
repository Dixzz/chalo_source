package defpackage;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;

/* renamed from: cc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class cc4 implements Runnable {
    public final /* synthetic */ zzz f;
    public final /* synthetic */ zzn g;
    public final /* synthetic */ ac4 h;

    public cc4(ac4 ac4, zzz zzz, zzn zzn) {
        this.h = ac4;
        this.f = zzz;
        this.g = zzn;
    }

    public final void run() {
        this.h.f.R();
        if (this.f.h.l1() == null) {
            this.h.f.F(this.f, this.g);
        } else {
            this.h.f.p(this.f, this.g);
        }
    }
}
