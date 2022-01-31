package defpackage;

import android.os.Bundle;
import defpackage.a32;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: y42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class y42 implements a32.b {
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ c42 g;
    public final /* synthetic */ d52 h;

    public y42(d52 d52, AtomicReference atomicReference, c42 c42) {
        this.h = d52;
        this.f = atomicReference;
        this.g = c42;
    }

    @Override // defpackage.n32
    public final void C(int i) {
    }

    @Override // defpackage.n32
    public final void L(Bundle bundle) {
        d52 d52 = this.h;
        a32 a32 = (a32) this.f.get();
        Objects.requireNonNull(a32, "null reference");
        c42 c42 = this.g;
        Objects.requireNonNull(d52);
        Objects.requireNonNull(m82.d);
        a32.j(new p82(a32)).b(new a52(d52, c42, true, a32));
    }
}
