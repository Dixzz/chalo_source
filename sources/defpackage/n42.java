package defpackage;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: n42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class n42 extends f52 {
    public final /* synthetic */ ConnectionResult b;
    public final /* synthetic */ p42 c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n42(p42 p42, e52 e52, ConnectionResult connectionResult) {
        super(e52);
        this.c = p42;
        this.b = connectionResult;
    }

    @Override // defpackage.f52
    @GuardedBy("mLock")
    public final void a() {
        this.c.h.m(this.b);
    }
}
