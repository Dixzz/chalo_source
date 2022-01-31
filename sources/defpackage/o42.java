package defpackage;

import com.google.android.gms.common.ConnectionResult;
import defpackage.w72;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: o42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class o42 extends f52 {
    public final /* synthetic */ w72.c b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o42(e52 e52, w72.c cVar) {
        super(e52);
        this.b = cVar;
    }

    @Override // defpackage.f52
    @GuardedBy("mLock")
    public final void a() {
        this.b.a(new ConnectionResult(16, null));
    }
}
