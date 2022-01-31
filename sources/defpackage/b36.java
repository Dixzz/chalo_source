package defpackage;

import defpackage.m36;
import java.util.Objects;

/* renamed from: b36  reason: default package */
/* compiled from: Manager */
public class b36 implements m36.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e36 f373a;
    public final /* synthetic */ t26 b;
    public final /* synthetic */ String c;

    public b36(t26 t26, e36 e36, t26 t262, String str) {
        this.f373a = e36;
        this.b = t262;
        this.c = str;
    }

    @Override // defpackage.m36.a
    public void a(Object... objArr) {
        e36 e36 = this.f373a;
        this.b.g(this.c);
        Objects.requireNonNull(e36);
    }
}
