package defpackage;

import defpackage.m36;
import defpackage.t26;
import java.util.Objects;

/* renamed from: y26  reason: default package */
/* compiled from: Manager */
public class y26 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t26 f3993a;

    public y26(t26 t26) {
        this.f3993a = t26;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        t26 t26 = this.f3993a;
        Objects.requireNonNull(t26);
        t26.w.fine("onclose");
        t26.e();
        t26.k.d = 0;
        t26.b = t26.g.CLOSED;
        t26.a("close", (String) objArr[0]);
        if (t26.c && !t26.d) {
            t26.i();
        }
    }
}
