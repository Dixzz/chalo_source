package defpackage;

import android.os.SystemClock;
import java.util.Objects;

/* renamed from: dg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class dg4 extends j64 {
    public final /* synthetic */ eg4 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public dg4(eg4 eg4, uc4 uc4) {
        super(uc4);
        this.e = eg4;
    }

    @Override // defpackage.j64
    public final void a() {
        eg4 eg4 = this.e;
        eg4.d.b();
        Objects.requireNonNull((db2) eg4.d.f3331a.n);
        eg4.a(false, false, SystemClock.elapsedRealtime());
        b64 j = eg4.d.j();
        Objects.requireNonNull((db2) eg4.d.f3331a.n);
        j.s(SystemClock.elapsedRealtime());
    }
}
