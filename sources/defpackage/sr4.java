package defpackage;

import android.os.Bundle;

/* renamed from: sr4  reason: default package */
public final class sr4 extends pr4<Void> {
    public final /* synthetic */ ur4 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public sr4(ur4 ur4, ay4<Void> ay4) {
        super(ur4, ay4);
        this.h = ur4;
    }

    @Override // defpackage.pr4, defpackage.ax4
    public final void w2(Bundle bundle, Bundle bundle2) {
        super.w2(bundle, bundle2);
        if (!this.h.e.compareAndSet(true, false)) {
            ur4.f.b(5, "Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.h.j();
        }
    }
}
