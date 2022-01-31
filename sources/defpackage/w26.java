package defpackage;

import defpackage.m36;
import java.util.Date;

/* renamed from: w26  reason: default package */
/* compiled from: Manager */
public class w26 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t26 f3714a;

    public w26(t26 t26) {
        this.f3714a = t26;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        t26 t26 = this.f3714a;
        Object[] objArr2 = new Object[1];
        objArr2[0] = Long.valueOf(t26.n != null ? new Date().getTime() - t26.n.getTime() : 0);
        t26.f("pong", objArr2);
    }
}
