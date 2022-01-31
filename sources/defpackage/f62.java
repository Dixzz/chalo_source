package defpackage;

import com.google.android.gms.common.ConnectionResult;

/* renamed from: f62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class f62 implements Runnable {
    public final /* synthetic */ i62 f;

    public f62(i62 i62) {
        this.f = i62;
    }

    public final void run() {
        ((s52) this.f.l).b(new ConnectionResult(4));
    }
}
