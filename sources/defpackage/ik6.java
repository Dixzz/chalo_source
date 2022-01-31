package defpackage;

import defpackage.ci6;

/* renamed from: ik6  reason: default package */
/* compiled from: HeadersReader.kt */
public final class ik6 {

    /* renamed from: a  reason: collision with root package name */
    public long f1530a = ((long) 262144);
    public final ym6 b;

    public ik6(ym6 ym6) {
        n86.f(ym6, "source");
        this.b = ym6;
    }

    public final ci6 a() {
        ci6.a aVar = new ci6.a();
        while (true) {
            String b2 = b();
            if (b2.length() == 0) {
                return aVar.d();
            }
            aVar.b(b2);
        }
    }

    public final String b() {
        String c0 = this.b.c0(this.f1530a);
        this.f1530a -= (long) c0.length();
        return c0;
    }
}
