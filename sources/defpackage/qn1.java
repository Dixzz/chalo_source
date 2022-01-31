package defpackage;

import defpackage.st1;
import defpackage.vt1;

/* renamed from: qn1  reason: default package */
/* compiled from: LockedResource */
public final class qn1<Z> implements rn1<Z>, st1.d {
    public static final v7<qn1<?>> j = new st1.c(new x7(20), new a(), st1.f3253a);
    public final vt1 f = new vt1.b();
    public rn1<Z> g;
    public boolean h;
    public boolean i;

    /* renamed from: qn1$a */
    /* compiled from: LockedResource */
    public static class a implements st1.b<qn1<?>> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.st1.b
        public qn1<?> a() {
            return new qn1();
        }
    }

    @Override // defpackage.rn1
    public synchronized void a() {
        this.f.a();
        this.i = true;
        if (!this.h) {
            this.g.a();
            this.g = null;
            j.a(this);
        }
    }

    @Override // defpackage.rn1
    public int b() {
        return this.g.b();
    }

    @Override // defpackage.rn1
    public Class<Z> c() {
        return this.g.c();
    }

    public synchronized void d() {
        this.f.a();
        if (this.h) {
            this.h = false;
            if (this.i) {
                a();
            }
        } else {
            throw new IllegalStateException("Already unlocked");
        }
    }

    @Override // defpackage.st1.d
    public vt1 g() {
        return this.f;
    }

    @Override // defpackage.rn1
    public Z get() {
        return this.g.get();
    }
}
