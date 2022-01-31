package defpackage;

import defpackage.t26;
import java.util.Objects;

/* renamed from: g36  reason: default package */
/* compiled from: Socket */
public class g36 implements Runnable {
    public final /* synthetic */ e36 f;

    public g36(e36 e36) {
        this.f = e36;
    }

    public void run() {
        if (!this.f.b) {
            e36 e36 = this.f;
            if (e36.h == null) {
                e36.h = new f36(e36, e36.e);
            }
            t26 t26 = this.f.e;
            Objects.requireNonNull(t26);
            c56.a(new s26(t26, null));
            t26.g gVar = t26.g.OPEN;
            e36 e362 = this.f;
            if (gVar == e362.e.b) {
                e36.e(e362);
            }
            this.f.a("connecting", new Object[0]);
        }
    }
}
