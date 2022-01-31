package defpackage;

import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;

/* renamed from: pc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class pc4 implements Runnable {
    public final /* synthetic */ zzku f;
    public final /* synthetic */ zzn g;
    public final /* synthetic */ ac4 h;

    public pc4(ac4 ac4, zzku zzku, zzn zzn) {
        this.h = ac4;
        this.f = zzku;
        this.g = zzn;
    }

    public final void run() {
        this.h.f.R();
        if (this.f.l1() == null) {
            this.h.f.D(this.f, this.g);
        } else {
            this.h.f.n(this.f, this.g);
        }
    }
}
