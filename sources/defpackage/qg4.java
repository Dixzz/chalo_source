package defpackage;

import android.os.Bundle;
import java.util.Objects;

/* renamed from: qg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class qg4 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ Bundle g;
    public final /* synthetic */ og4 h;

    public qg4(og4 og4, String str, Bundle bundle) {
        this.h = og4;
        this.f = str;
        this.g = bundle;
    }

    public final void run() {
        ug4 t = this.h.f2690a.j.t();
        String str = this.f;
        Bundle bundle = this.g;
        Objects.requireNonNull((db2) this.h.f2690a.j.n);
        this.h.f2690a.k(t.A(str, "_err", bundle, "auto", System.currentTimeMillis(), false, false), this.f);
    }
}
