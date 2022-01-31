package defpackage;

import defpackage.m36;
import java.util.Date;
import java.util.Objects;

/* renamed from: v26  reason: default package */
/* compiled from: Manager */
public class v26 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t26 f3586a;

    public v26(t26 t26) {
        this.f3586a = t26;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        t26 t26 = this.f3586a;
        Objects.requireNonNull(t26);
        t26.n = new Date();
        t26.f("ping", new Object[0]);
    }
}
