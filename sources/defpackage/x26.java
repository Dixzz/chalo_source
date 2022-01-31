package defpackage;

import defpackage.m36;
import java.util.Objects;
import java.util.logging.Level;

/* renamed from: x26  reason: default package */
/* compiled from: Manager */
public class x26 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t26 f3875a;

    public x26(t26 t26) {
        this.f3875a = t26;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        t26 t26 = this.f3875a;
        Exception exc = (Exception) objArr[0];
        Objects.requireNonNull(t26);
        t26.w.log(Level.FINE, "error", (Throwable) exc);
        t26.f("error", exc);
    }
}
