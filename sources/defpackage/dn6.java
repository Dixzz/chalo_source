package defpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: dn6  reason: default package */
/* compiled from: ForwardingTimeout.kt */
public class dn6 extends rn6 {
    public rn6 e;

    public dn6(rn6 rn6) {
        n86.f(rn6, "delegate");
        this.e = rn6;
    }

    @Override // defpackage.rn6
    public rn6 a() {
        return this.e.a();
    }

    @Override // defpackage.rn6
    public rn6 b() {
        return this.e.b();
    }

    @Override // defpackage.rn6
    public long c() {
        return this.e.c();
    }

    @Override // defpackage.rn6
    public rn6 d(long j) {
        return this.e.d(j);
    }

    @Override // defpackage.rn6
    public boolean e() {
        return this.e.e();
    }

    @Override // defpackage.rn6
    public void f() throws IOException {
        this.e.f();
    }

    @Override // defpackage.rn6
    public rn6 g(long j, TimeUnit timeUnit) {
        n86.f(timeUnit, "unit");
        return this.e.g(j, timeUnit);
    }

    @Override // defpackage.rn6
    public long h() {
        return this.e.h();
    }
}
