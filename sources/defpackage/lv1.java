package defpackage;

import defpackage.bv1;
import defpackage.cv1;
import defpackage.jv1;
import java.util.HashMap;
import java.util.Objects;

/* renamed from: lv1  reason: default package */
/* compiled from: TransportImpl */
public final class lv1<T> implements du1<T> {

    /* renamed from: a  reason: collision with root package name */
    public final jv1 f2281a;
    public final String b;
    public final zt1 c;
    public final cu1<T, byte[]> d;
    public final mv1 e;

    public lv1(jv1 jv1, String str, zt1 zt1, cu1<T, byte[]> cu1, mv1 mv1) {
        this.f2281a = jv1;
        this.b = str;
        this.c = zt1;
        this.d = cu1;
        this.e = mv1;
    }

    public void a(au1<T> au1, fu1 fu1) {
        mv1 mv1 = this.e;
        jv1 jv1 = this.f2281a;
        Objects.requireNonNull(jv1, "Null transportContext");
        Objects.requireNonNull(au1, "Null event");
        String str = this.b;
        Objects.requireNonNull(str, "Null transportName");
        cu1<T, byte[]> cu1 = this.d;
        Objects.requireNonNull(cu1, "Null transformer");
        zt1 zt1 = this.c;
        Objects.requireNonNull(zt1, "Null encoding");
        if (1 != 0) {
            nv1 nv1 = (nv1) mv1;
            kw1 kw1 = nv1.c;
            bu1 c2 = au1.c();
            Objects.requireNonNull(jv1);
            jv1.a a2 = jv1.a();
            a2.b(jv1.b());
            a2.c(c2);
            cv1.b bVar = (cv1.b) a2;
            bVar.b = jv1.c();
            jv1 a3 = bVar.a();
            bv1.b bVar2 = new bv1.b();
            bVar2.f = new HashMap();
            bVar2.e(nv1.f2608a.a());
            bVar2.g(nv1.b.a());
            bVar2.f(str);
            bVar2.d(new fv1(zt1, cu1.apply(au1.b())));
            bVar2.b = au1.a();
            kw1.a(a3, bVar2.b(), fu1);
            return;
        }
        throw new IllegalStateException(hj1.S("Missing required properties:", ""));
    }
}
